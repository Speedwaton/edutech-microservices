package com.edutech.support.mapper;

import com.edutech.support.entity.SupportTicket;
import com.edutech.common.dto.SupportTicketDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class SupportTicketMapper {
    
    public SupportTicketDTO toDTO(SupportTicket entity) {
        if (entity == null) {
            return null;
        }
        
        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(entity.getId() != null ? entity.getId().intValue() : null);
        dto.setUserId(entity.getUserId());
        dto.setSupportUserId(entity.getSupportUserId());
        dto.setSubject(entity.getSubject());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt() != null ? entity.getCreatedAt().toInstant(ZoneOffset.UTC) : null);
        dto.setClosedAt(entity.getClosedAt() != null ? entity.getClosedAt().toInstant(ZoneOffset.UTC) : null);
        
        return dto;
    }
    
    public SupportTicket toEntity(SupportTicketDTO dto) {
        if (dto == null) {
            return null;
        }
        
        SupportTicket entity = new SupportTicket();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setUserId(dto.getUserId());
        entity.setSupportUserId(dto.getSupportUserId());
        entity.setSubject(dto.getSubject());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        if (dto.getCreatedAt() != null) {
            entity.setCreatedAt(LocalDateTime.ofInstant(dto.getCreatedAt(), ZoneOffset.UTC));
        }
        if (dto.getClosedAt() != null) {
            entity.setClosedAt(LocalDateTime.ofInstant(dto.getClosedAt(), ZoneOffset.UTC));
        }
        
        return entity;
    }
}
