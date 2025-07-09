package com.edutech.support.service;

import com.edutech.support.entity.SupportTicket;
import com.edutech.support.mapper.SupportTicketMapper;
import com.edutech.support.repository.SupportTicketRepository;
import com.edutech.common.dto.SupportTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupportTicketService {
    
    @Autowired
    private SupportTicketRepository repository;
    
    @Autowired
    private SupportTicketMapper mapper;
    
    public List<SupportTicketDTO> getAllSupportTickets() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<SupportTicketDTO> getSupportTicketById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }
    
    public List<SupportTicketDTO> getSupportTicketsByUserId(Integer userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public List<SupportTicketDTO> getSupportTicketsByStatus(String status) {
        return repository.findByStatus(status)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public SupportTicketDTO createSupportTicket(SupportTicketDTO dto) {
        SupportTicket entity = mapper.toEntity(dto);
        entity.setId(null); // Asegurar que es una nueva entidad
        if (entity.getStatus() == null) {
            entity.setStatus("Open"); // Estado por defecto
        }
        SupportTicket saved = repository.save(entity);
        return mapper.toDTO(saved);
    }
    
    public Optional<SupportTicketDTO> updateSupportTicket(Long id, SupportTicketDTO dto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setSubject(dto.getSubject() != null ? dto.getSubject() : existing.getSubject());
                    existing.setDescription(dto.getDescription() != null ? dto.getDescription() : existing.getDescription());
                    existing.setStatus(dto.getStatus() != null ? dto.getStatus() : existing.getStatus());
                    existing.setSupportUserId(dto.getSupportUserId() != null ? dto.getSupportUserId() : existing.getSupportUserId());
                    
                    // Si se cambia a "Closed", establecer fecha de cierre
                    if ("Closed".equals(dto.getStatus()) && existing.getClosedAt() == null) {
                        existing.setClosedAt(LocalDateTime.now());
                    }
                    
                    return mapper.toDTO(repository.save(existing));
                });
    }
    
    public boolean deleteSupportTicket(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
