package com.edutech.courses.service;

import com.edutech.common.dto.CourseCategoryDTO;
import com.edutech.courses.entity.CourseCategory;
import com.edutech.courses.mapper.CourseCategoryMapper;
import com.edutech.courses.repository.CourseCategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

@Service
@RequiredArgsConstructor
public class CourseCategoryService {

    private final CourseCategoryRepository categRepo;
    private final CourseCategoryMapper categMapper;

    public List<CourseCategoryDTO> findAll() {
        return categRepo.findAll().stream().map(categMapper::toDTO).toList();
    }

    public CourseCategoryDTO findById(Integer id) {
        return categMapper.toDTO(orThrow(categRepo.findById(id), "Categoría"));
    }

    public CourseCategoryDTO create(CourseCategoryDTO dto) {
        return saveDTO(dto, null);
    }

    public CourseCategoryDTO update(Integer id, CourseCategoryDTO dto) {
        orThrow(categRepo.findById(id), "Categoría");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        categRepo.delete(orThrow(categRepo.findById(id), "Categoría"));
    }

    private CourseCategoryDTO saveDTO(CourseCategoryDTO dto, Integer id) {
        CourseCategory entity;
        
        if (id != null) {
            // Para actualización: obtener la entidad existente y actualizar solo los campos necesarios
            entity = orThrow(categRepo.findById(id), "Categoría");
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            // Hibernate maneja automáticamente el campo version en optimistic locking
        } else {
            // Para creación: nueva entidad
            entity = categMapper.toEntity(dto);
        }
        return categMapper.toDTO(categRepo.save(entity));
    }
}
