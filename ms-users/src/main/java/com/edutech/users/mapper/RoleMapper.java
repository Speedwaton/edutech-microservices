package com.edutech.users.mapper;

import com.edutech.common.dto.RoleDTO;
import com.edutech.users.entity.Role;
import org.springframework.stereotype.Component;

/**
 * Implementación manual del mapper para roles
 */
@Component
public class RoleMapper {
    public Role toEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Role role = new Role();
        if (dto.getId() != null) {
            role.setId(dto.getId());
        }
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        return role;
    }
    
    public RoleDTO toDTO(Role entity) {
        if (entity == null) {
            return null;
        }
        
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
