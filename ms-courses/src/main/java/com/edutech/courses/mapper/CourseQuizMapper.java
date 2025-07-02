package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.entity.CourseQuiz;

import org.mapstruct.Mapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseQuizMapper {
    CourseQuizDTO toDTO(CourseQuiz entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "questions", ignore = true)
    CourseQuiz toEntity(CourseQuizDTO dto);
}
