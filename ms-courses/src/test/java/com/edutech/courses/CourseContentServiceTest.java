package com.edutech.courses;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import com.edutech.courses.mapper.CourseContentMapper;
import com.edutech.courses.repository.CourseContentRepository;
import com.edutech.courses.service.CourseContentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseContentServiceTest {

    @Mock
    private CourseContentRepository contentRepo;
    @Mock
    private CourseContentMapper contentMapper;

    @InjectMocks
    private CourseContentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        CourseContent entity = new CourseContent();
        entity.setId(1);
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(1);

        when(contentRepo.findById(1)).thenReturn(Optional.of(entity));
        when(contentMapper.toDto(entity)).thenReturn(dto);

        CourseContentDTO result = service.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }
}
