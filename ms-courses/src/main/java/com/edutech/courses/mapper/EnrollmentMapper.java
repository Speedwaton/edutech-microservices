package com.edutech.courses.mapper;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.entity.Enrollment;
import org.mapstruct.Mapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDTO toDTO(Enrollment entity);

    @Mapping(target = "enrolledAt", ignore = true)
    Enrollment toEntity(EnrollmentDTO dto);
}
