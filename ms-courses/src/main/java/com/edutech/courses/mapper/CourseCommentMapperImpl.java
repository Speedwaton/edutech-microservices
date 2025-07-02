package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;
import org.springframework.stereotype.Component;

@Component
public class CourseCommentMapperImpl implements CourseCommentMapper {

    @Override
    public CourseCommentDTO toDTO(CourseComment entity) {
        if (entity == null) {
            return null;
        }

        CourseCommentDTO dto = new CourseCommentDTO();
        
        // Usando getters/setters explícitos
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setUserId(entity.getUserId());
        dto.setCommentText(entity.getCommentText());
        dto.setRating(entity.getRating());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }

    @Override
    public CourseComment toEntity(CourseCommentDTO dto) {
        if (dto == null) {
            return null;
        }

        CourseComment entity = new CourseComment();
        
        // No asignamos ID, createdAt ni version para que sean manejados por el servicio
        entity.setCourseId(dto.getCourseId());
        entity.setUserId(dto.getUserId());
        entity.setCommentText(dto.getCommentText());
        entity.setRating(dto.getRating());

        return entity;
    }
}
