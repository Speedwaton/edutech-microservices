package com.edutech.grades.service;

import com.edutech.grades.entity.StudentMark;
import com.edutech.grades.mapper.StudentMarkMapper;
import com.edutech.grades.repository.StudentMarkRepository;
import com.edutech.common.dto.StudentMarkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentMarkService {
    
    @Autowired
    private StudentMarkRepository repository;
    
    @Autowired
    private StudentMarkMapper mapper;
    
    public List<StudentMarkDTO> getAllStudentMarks() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<StudentMarkDTO> getStudentMarkById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }
    
    public List<StudentMarkDTO> getStudentMarksByStudentId(Long studentId) {
        return repository.findByStudentId(studentId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public List<StudentMarkDTO> getStudentMarksByQuizId(Long quizId) {
        return repository.findByQuizId(quizId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public StudentMarkDTO createStudentMark(StudentMarkDTO dto) {
        StudentMark entity = mapper.toEntity(dto);
        entity.setId(null); // Asegurar que es una nueva entidad
        StudentMark saved = repository.save(entity);
        return mapper.toDTO(saved);
    }
    
    public Optional<StudentMarkDTO> updateStudentMark(Long id, StudentMarkDTO dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setQuizId(dto.getQuizId() != null ? dto.getQuizId().longValue() : existing.getQuizId());
                    existing.setStudentId(dto.getStudentId() != null ? dto.getStudentId().longValue() : existing.getStudentId());
                    existing.setMark(dto.getMark() != null ? dto.getMark() : existing.getMark());
                    existing.setComments(dto.getComments() != null ? dto.getComments() : existing.getComments());
                    return mapper.toDTO(repository.save(existing));
                });
    }
    
    public boolean deleteStudentMark(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
