package com.edutech.courses;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;
import com.edutech.courses.mapper.CourseCommentMapper;
import com.edutech.courses.repository.CourseCommentRepository;
import com.edutech.courses.service.CourseCommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseCommentServiceTest {

    @Mock
    private CourseCommentRepository commentRepo;
    @Mock
    private CourseCommentMapper commentMapper;

    @InjectMocks
    private CourseCommentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Arrange
        CourseComment entity = new CourseComment();
        entity.setId(1);
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(1);

        when(commentRepo.findById(1)).thenReturn(Optional.of(entity));
        when(commentMapper.toDTO(entity)).thenReturn(dto);

        // Act
        CourseCommentDTO result = service.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getId());
    }
}
