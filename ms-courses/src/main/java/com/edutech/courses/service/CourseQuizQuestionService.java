package com.edutech.courses.service;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.entity.CourseQuizQuestion;
import com.edutech.courses.mapper.CourseQuizQuestionMapper;
import com.edutech.courses.repository.CourseQuizQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizQuestionService {

    private final CourseQuizQuestionRepository questionRepo;
    private final CourseQuizQuestionMapper questionMapper;

    public List<CourseQuizQuestionDTO> findAll() {
        return questionRepo.findAll().stream().map(questionMapper::toDTO).toList();
    }

    public CourseQuizQuestionDTO findById(int id) {
        return questionRepo.findById(id)
                .map(questionMapper::toDTO)
                .orElse(null);
    }

    public CourseQuizQuestionDTO create(CourseQuizQuestionDTO dto) {
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        // createdAt se maneja automáticamente con @CreationTimestamp
        return questionMapper.toDTO(questionRepo.save(entity));
    }

    public CourseQuizQuestionDTO update(int id, CourseQuizQuestionDTO dto) {
        // Obtener la entidad existente para preservar campos automáticos
        CourseQuizQuestion existingEntity = questionRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Pregunta de quiz no encontrada"));
        
        CourseQuizQuestion entity = questionMapper.toEntity(dto);
        entity.setId(id);
        entity.setCreatedAt(existingEntity.getCreatedAt()); // Preservar createdAt
        return questionMapper.toDTO(questionRepo.save(entity));
    }

    public void delete(int id) {
        questionRepo.deleteById(id);
    }
}