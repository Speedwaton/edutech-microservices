package com.edutech.grades.mapper;

import com.edutech.grades.entity.StudentMark;
import com.edutech.common.dto.StudentMarkDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class StudentMarkMapper {
    
    public StudentMarkDTO toDTO(StudentMark entity) {
        if (entity == null) {
            return null;
        }
        
        StudentMarkDTO dto = new StudentMarkDTO();
        dto.setId(entity.getId() != null ? entity.getId().intValue() : null);
        dto.setQuizId(entity.getQuizId() != null ? entity.getQuizId().intValue() : null);
        dto.setStudentId(entity.getStudentId() != null ? entity.getStudentId().intValue() : null);
        dto.setMark(entity.getMark());
        dto.setComments(entity.getComments());
        dto.setGradedAt(entity.getGradedAt() != null ? entity.getGradedAt().toInstant(ZoneOffset.UTC) : null);
        
        return dto;
    }
    
    public StudentMark toEntity(StudentMarkDTO dto) {
        if (dto == null) {
            return null;
        }
        
        StudentMark entity = new StudentMark();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setQuizId(dto.getQuizId() != null ? dto.getQuizId().longValue() : null);
        entity.setStudentId(dto.getStudentId() != null ? dto.getStudentId().longValue() : null);
        entity.setMark(dto.getMark());
        entity.setComments(dto.getComments());
        if (dto.getGradedAt() != null) {
            entity.setGradedAt(LocalDateTime.ofInstant(dto.getGradedAt(), ZoneOffset.UTC));
        }
        
        return entity;
    }
}
