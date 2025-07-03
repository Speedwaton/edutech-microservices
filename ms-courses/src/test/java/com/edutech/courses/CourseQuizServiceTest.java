package com.edutech.courses;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.entity.CourseQuiz;
import com.edutech.courses.mapper.CourseQuizMapper;
import com.edutech.courses.repository.CourseQuizRepository;
import com.edutech.courses.service.CourseQuizService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseQuizServiceTest {

    @Mock
    private CourseQuizRepository quizRepo;
    @Mock
    private CourseQuizMapper quizMapper;

    @InjectMocks
    private CourseQuizService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(1);
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(1);

        when(quizRepo.findById(1)).thenReturn(Optional.of(entity));
        when(quizMapper.toDTO(entity)).thenReturn(dto);

        CourseQuizDTO result = service.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }
}
