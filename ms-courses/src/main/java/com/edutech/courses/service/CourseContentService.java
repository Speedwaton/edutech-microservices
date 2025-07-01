package com.edutech.courses.service;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import com.edutech.courses.mapper.CourseContentMapper;
import com.edutech.courses.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {

    private final CourseContentRepository contentRepo;
    private final CourseContentMapper contentMapper;

    public List<CourseContentDTO> findAll() {
        return contentRepo.findAll().stream().map(contentMapper::toDto).toList();
    }

    public CourseContentDTO findById(int id) {
        return contentRepo.findById(id)
                .map(contentMapper::toDto)
                .orElse(null);
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        CourseContent entity = contentMapper.toEntity(dto);
        // Para creates, no necesitamos establecer version (Hibernate lo manejará automáticamente)
        return contentMapper.toDto(contentRepo.save(entity));
    }

    public CourseContentDTO update(int id, CourseContentDTO dto) {
        CourseContent entity = contentMapper.toEntity(dto);
        entity.setId(id);
        return contentMapper.toDto(contentRepo.save(entity));
    }

    public void delete(int id) {
        contentRepo.deleteById(id);
    }
}