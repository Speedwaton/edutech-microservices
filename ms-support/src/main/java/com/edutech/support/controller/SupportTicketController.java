package com.edutech.support.controller;

import com.edutech.support.service.SupportTicketService;
import com.edutech.common.dto.SupportTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {
    
    @Autowired
    private SupportTicketService service;
    
    @GetMapping
    public ResponseEntity<List<SupportTicketDTO>> getAllSupportTickets() {
        List<SupportTicketDTO> tickets = service.getAllSupportTickets();
        return ResponseEntity.ok(tickets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> getSupportTicketById(@PathVariable Long id) {
        Optional<SupportTicketDTO> ticket = service.getSupportTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SupportTicketDTO>> getSupportTicketsByUserId(@PathVariable Integer userId) {
        List<SupportTicketDTO> tickets = service.getSupportTicketsByUserId(userId);
        return ResponseEntity.ok(tickets);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<SupportTicketDTO>> getSupportTicketsByStatus(@PathVariable String status) {
        List<SupportTicketDTO> tickets = service.getSupportTicketsByStatus(status);
        return ResponseEntity.ok(tickets);
    }
    
    @PostMapping
    public ResponseEntity<SupportTicketDTO> createSupportTicket(@RequestBody SupportTicketDTO dto) {
        try {
            SupportTicketDTO created = service.createSupportTicket(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketDTO> updateSupportTicket(@PathVariable Long id, @RequestBody SupportTicketDTO dto) {
        Optional<SupportTicketDTO> updated = service.updateSupportTicket(id, dto);
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
        if (service.deleteSupportTicket(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
