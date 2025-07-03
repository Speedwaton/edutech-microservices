package com.edutech.courses;

import com.edutech.common.dto.CourseDTO;
import com.edutech.courses.client.UserClient;
import com.edutech.courses.entity.Course;
import com.edutech.courses.entity.CourseCategory;
import com.edutech.common.dto.UserDTO;
import com.edutech.courses.mapper.CourseMapper;
import com.edutech.courses.repository.CourseCategoryRepository;
import com.edutech.courses.repository.CourseRepository;
import com.edutech.courses.service.CourseService;
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

public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepo;
    @Mock
    private CourseCategoryRepository categRepo;
    @Mock
    private CourseMapper courseMapper;
    @Mock
    private UserClient userClient;

    @InjectMocks
    private CourseService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Course entity = new Course();
        CourseDTO dto = new CourseDTO();
        when(courseRepo.findAll()).thenReturn(Arrays.asList(entity));
        when(courseMapper.toDTO(entity)).thenReturn(dto);

        List<CourseDTO> result = service.findAll();

        assertThat(result).hasSize(1);
        verify(courseRepo).findAll();
    }

    @Test
    void testFindById() {
        Course entity = new Course();
        entity.setId(1);
        CourseDTO dto = new CourseDTO();
        dto.setId(1);

        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));
        when(courseMapper.toDTO(entity)).thenReturn(dto);

        CourseDTO result = service.findById(1);

        assertThat(result.getId()).isEqualTo(1);
        verify(courseRepo).findById(1);
    }

    @Test
    void testCreate() {
        CourseDTO dto = new CourseDTO();
        dto.setCategoryId(1);
        dto.setManagerId(2);
        dto.setInstructorId(3);

        // Usa los tipos correctos:
        CourseCategory category = new CourseCategory();
        when(categRepo.findById(1)).thenReturn(Optional.of(category));

        UserDTO manager = new UserDTO();
        UserDTO instructor = new UserDTO();
        when(userClient.findById(2)).thenReturn(manager);
        when(userClient.findById(3)).thenReturn(instructor);

        Course entity = new Course();
        when(courseMapper.toEntity(dto)).thenReturn(entity);
        when(courseRepo.save(entity)).thenReturn(entity);
        when(courseMapper.toDTO(entity)).thenReturn(dto);

        CourseDTO result = service.create(dto);

        assertNotNull(result);
    }

    @Test
    void testUpdate() {
        Course entity = new Course();
        entity.setId(1);

        CourseDTO dto = new CourseDTO();
        dto.setId(1);
        dto.setTitle("Actualizado");
        dto.setCreatedAt(Instant.now());

        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));
        when(courseMapper.toEntity(dto)).thenReturn(entity);
        when(courseRepo.save(entity)).thenReturn(entity);
        when(courseMapper.toDTO(entity)).thenReturn(dto);

        CourseDTO result = service.update(1, dto);

        assertThat(result.getTitle()).isEqualTo("Actualizado");
        verify(courseRepo).save(entity);
    }

    @Test
    void testDelete() {
        Course entity = new Course();
        entity.setId(1);

        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));

        service.delete(1);

        verify(courseRepo).delete(entity);
    }
}
