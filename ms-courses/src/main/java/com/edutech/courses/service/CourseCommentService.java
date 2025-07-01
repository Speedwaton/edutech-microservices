package com.edutech.courses.service;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;
import com.edutech.courses.mapper.CourseCommentMapper;
import com.edutech.courses.repository.CourseCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCommentService {

    private final CourseCommentRepository commentRepo;
    private final CourseCommentMapper commentMapper;
    
    public CourseCommentService(CourseCommentRepository commentRepo, CourseCommentMapper commentMapper) {
        this.commentRepo = commentRepo;
        this.commentMapper = commentMapper;
    }

    public List<CourseCommentDTO> findAll() {
        return commentRepo.findAll().stream().map(commentMapper::toDTO).toList();
    }

    public CourseCommentDTO findById(int id) {
        return commentRepo.findById(id)
                .map(commentMapper::toDTO)
                .orElse(null);
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        CourseComment entity = commentMapper.toEntity(dto);
        // createdAt se maneja automáticamente con @CreationTimestamp
        return commentMapper.toDTO(commentRepo.save(entity));
    }

    public CourseCommentDTO update(int id, CourseCommentDTO dto) {
        // Obtener la entidad existente para preservar campos automáticos
        CourseComment existingEntity = commentRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        
        CourseComment entity = commentMapper.toEntity(dto);
        entity.setId(id);
        entity.setCreatedAt(existingEntity.getCreatedAt()); // Preservar createdAt
        return commentMapper.toDTO(commentRepo.save(entity));
    }

    public void delete(int id) {
        commentRepo.deleteById(id);
    }
}
