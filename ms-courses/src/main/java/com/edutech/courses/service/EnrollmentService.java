package com.edutech.courses.service;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.entity.Enrollment;
import com.edutech.courses.mapper.EnrollmentMapper;
import com.edutech.courses.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;

    public EnrollmentService(EnrollmentRepository repository, EnrollmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EnrollmentDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public EnrollmentDTO findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public EnrollmentDTO create(EnrollmentDTO dto) {
        Enrollment entity = mapper.toEntity(dto);
        // Asegurar que enrolledAt se establece si no viene del DTO
        if (entity.getEnrolledAt() == null) {
            entity.setEnrolledAt(Instant.now());
        }
        // version se inicializa automáticamente por Hibernate
        return mapper.toDTO(repository.save(entity));
    }

    public EnrollmentDTO update(Integer id, EnrollmentDTO dto) {
        // Obtener la entidad existente para preservar campos automáticos
        Enrollment existingEntity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
        
        Enrollment entity = mapper.toEntity(dto);
        entity.setId(id);
        entity.setEnrolledAt(existingEntity.getEnrolledAt()); // Preservar enrolledAt
        return mapper.toDTO(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
