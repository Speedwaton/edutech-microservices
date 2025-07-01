package com.edutech.courses.service;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.entity.CourseQuiz;
import com.edutech.courses.mapper.CourseQuizMapper;
import com.edutech.courses.repository.CourseQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizService {

    private final CourseQuizRepository quizRepo;
    private final CourseQuizMapper quizMapper;

    public List<CourseQuizDTO> findAll() {
        return quizRepo.findAll().stream().map(quizMapper::toDTO).toList();
    }

    public CourseQuizDTO findById(int id) {
        return quizRepo.findById(id)
                .map(quizMapper::toDTO)
                .orElse(null);
    }

    public CourseQuizDTO create(CourseQuizDTO dto) {
        CourseQuiz entity = quizMapper.toEntity(dto);
        // createdAt se maneja automáticamente con @CreationTimestamp
        return quizMapper.toDTO(quizRepo.save(entity));
    }

    public CourseQuizDTO update(int id, CourseQuizDTO dto) {
        // Obtener la entidad existente para preservar campos automáticos
        CourseQuiz existingEntity = quizRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
        
        CourseQuiz entity = quizMapper.toEntity(dto);
        entity.setId(id);
        entity.setCreatedAt(existingEntity.getCreatedAt()); // Preservar createdAt
        return quizMapper.toDTO(quizRepo.save(entity));
    }

    public void delete(int id) {
        quizRepo.deleteById(id);
    }
}