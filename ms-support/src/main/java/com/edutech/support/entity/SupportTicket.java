package com.edutech.support.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "support_ticket")
public class SupportTicket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Column(name = "support_user_id")
    private Integer supportUserId;
    
    @Column(name = "subject", nullable = false, length = 200)
    private String subject;
    
    @Column(name = "description", nullable = false, length = 800)
    private String description;
    
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "closed_at")
    private LocalDateTime closedAt;
    
    // Constructor vacío
    public SupportTicket() {}
    
    // Constructor con parámetros
    public SupportTicket(Integer userId, String subject, String description, String status) {
        this.userId = userId;
        this.subject = subject;
        this.description = description;
        this.status = status;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getSupportUserId() {
        return supportUserId;
    }
    
    public void setSupportUserId(Integer supportUserId) {
        this.supportUserId = supportUserId;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getClosedAt() {
        return closedAt;
    }
    
    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }
}
