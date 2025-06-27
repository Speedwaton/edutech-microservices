package com.edutech.users.service;

import com.edutech.common.dto.UserDTO;
import com.edutech.users.entity.User;
import com.edutech.users.mapper.UserMapper;
import com.edutech.users.repository.UserRepository;
import static com.edutech.common.exception.ExceptionUtils.orThrow;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;


    public List<UserDTO> findAll() {
        return userRepo.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserDTO findById(Integer id) {
        return userMapper.toDTO(orThrow(userRepo.findById(id), "Usuario"));
    }

    public UserDTO findByEmail(String email) {
        return userMapper.toDTO(orThrow(userRepo.findByEmail(email), "Usuario"));
    }

    public UserDTO create(UserDTO dto) {

        // Verificar que el nuevo usuario no tenga un email repetido, que ya usa otro usuario
        if (userRepo.findByEmail(dto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, 
                    "El email '" + dto.getEmail() + "' ya está registrado.");
        }

        return saveDTO(dto, null);
    }

    public UserDTO update(Integer id, UserDTO dto) {
        User existingUser = userRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Usuario no encontrado con ID: " + id
            ));
        
        // NO crear una nueva entidad, actualizar la existente
        existingUser.setFirstName(dto.getFirstName());
        existingUser.setLastName(dto.getLastName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPasswordHash(dto.getPasswordHash());
        existingUser.setRoleId(dto.getRoleId());
        existingUser.setIsActive(dto.getIsActive());
        // createdAt se mantiene igual, updatedAt se actualiza con @PreUpdate
        
        User savedUser = userRepo.save(existingUser);
        return userMapper.toDTO(savedUser);
    }

    public UserDTO partialUpdate(Integer id, UserDTO dto) {
        User existingUser = userRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Usuario no encontrado con ID: " + id
            ));
        
        // Actualizar solo los campos que no son null
        if (dto.getFirstName() != null) {
            existingUser.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            existingUser.setLastName(dto.getLastName());
        }
        if (dto.getEmail() != null) {
            existingUser.setEmail(dto.getEmail());
        }
        if (dto.getPasswordHash() != null) {
            existingUser.setPasswordHash(dto.getPasswordHash());
        }
        if (dto.getRoleId() != null) {
            existingUser.setRoleId(dto.getRoleId());
        }
        if (dto.getIsActive() != null) {
            existingUser.setIsActive(dto.getIsActive());
        }
        
        User savedUser = userRepo.save(existingUser);
        return userMapper.toDTO(savedUser);
    }

    // DESPUÉS (DELETE suave):
    public void delete(Integer id) {
        User user = orThrow(userRepo.findById(id), "Usuario");
        user.setIsActive(false);
        userRepo.save(user);
    }

    private UserDTO saveDTO(UserDTO dto, Integer id) {
        User entity = userMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return userMapper.toDTO(userRepo.save(entity));
    }
}
