package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.entity.CourseQuizQuestion;

import org.mapstruct.Mapper;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseQuizQuestionMapper {
    CourseQuizQuestionDTO toDTO(CourseQuizQuestion entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto);
}
