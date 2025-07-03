package com.edutech.courses;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.entity.Enrollment;
import com.edutech.courses.mapper.EnrollmentMapper;
import com.edutech.courses.repository.EnrollmentRepository;
import com.edutech.courses.service.EnrollmentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository repository;

    @Mock
    private EnrollmentMapper mapper;

    @InjectMocks
    private EnrollmentService service;

    public EnrollmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Enrollment entity = new Enrollment();
        entity.setId(1);
        entity.setStudentId(1);
        entity.setCourseId(1);
        entity.setStatus("active");

        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(1);
        dto.setStudentId(1);
        dto.setCourseId(1);
        dto.setStatus("active");

        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        List<EnrollmentDTO> result = service.findAll();
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getStudentId());
    }
}
