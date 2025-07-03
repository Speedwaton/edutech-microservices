package com.edutech.courses;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.entity.CourseQuizQuestion;
import com.edutech.courses.mapper.CourseQuizQuestionMapper;
import com.edutech.courses.repository.CourseQuizQuestionRepository;
import com.edutech.courses.service.CourseQuizQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseQuizQuestionServiceTest {

    @Mock
    private CourseQuizQuestionRepository questionRepo;

    @Mock
    private CourseQuizQuestionMapper questionMapper;

    @InjectMocks
    private CourseQuizQuestionService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        when(questionRepo.findAll()).thenReturn(Arrays.asList(entity));
        when(questionMapper.toDTO(entity)).thenReturn(dto);

        List<CourseQuizQuestionDTO> result = service.findAll();

        assertThat(result).hasSize(1);
        verify(questionRepo).findAll();
    }

    @Test
    void testFindById() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(1);
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(1);

        when(questionRepo.findById(1)).thenReturn(Optional.of(entity));
        when(questionMapper.toDTO(entity)).thenReturn(dto);

        CourseQuizQuestionDTO result = service.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testCreate() {
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setQuestionText("Pregunta");
        dto.setOrderIndex(1);
        dto.setCreatedAt(Instant.now());

        CourseQuizQuestion entity = new CourseQuizQuestion();
        when(questionMapper.toEntity(dto)).thenReturn(entity);
        when(questionRepo.save(entity)).thenReturn(entity);
        when(questionMapper.toDTO(entity)).thenReturn(dto);

        CourseQuizQuestionDTO result = service.create(dto);

        assertThat(result.getQuestionText()).isEqualTo("Pregunta");
        verify(questionRepo).save(entity);
    }

    @Test
    void testUpdate() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(1);

        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(1);
        dto.setQuestionText("Actualizada");
        dto.setOrderIndex(1);
        dto.setCreatedAt(Instant.now());

        when(questionRepo.findById(1)).thenReturn(Optional.of(entity));
        when(questionMapper.toEntity(dto)).thenReturn(entity);
        when(questionRepo.save(entity)).thenReturn(entity);
        when(questionMapper.toDTO(entity)).thenReturn(dto);

        CourseQuizQuestionDTO result = service.update(1, dto);

        assertThat(result.getQuestionText()).isEqualTo("Actualizada");
        verify(questionRepo).save(entity);
    }

    @Test
    void testDelete() {
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(1);

        when(questionRepo.findById(1)).thenReturn(Optional.of(entity));

        service.delete(1);

        verify(questionRepo).deleteById(eq(1));
    }
}
