package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;

// Eliminamos las anotaciones MapStruct para evitar problemas con el procesador
public interface CourseCommentMapper {
    CourseCommentDTO toDTO(CourseComment entity);
    CourseComment toEntity(CourseCommentDTO dto);
}
