package com.edutech.users.mapper;

import com.edutech.common.dto.UserDTO;
import com.edutech.users.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        }
        
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPasswordHash(entity.getPasswordHash());
        userDTO.setRoleId(entity.getRoleId());
        userDTO.setIsActive(entity.getIsActive());
        userDTO.setCreatedAt(entity.getCreatedAt());
        userDTO.setUpdatedAt(entity.getUpdatedAt());
        
        return userDTO;
    }
    
    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setRoleId(dto.getRoleId());
        user.setIsActive(dto.getIsActive());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        
        return user;
    }
}
