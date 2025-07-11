package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseContentMapper {
    CourseContent toEntity(CourseContentDTO dto);
    CourseContentDTO toDto(CourseContent entity);
}
