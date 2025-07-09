package com.edutech.grades.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_mark")
public class StudentMark {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "quiz_id", nullable = false)
    private Long quizId;
    
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    
    @Column(name = "mark", nullable = false, precision = 5, scale = 2)
    private BigDecimal mark;
    
    @Column(name = "comments", length = 800)
    private String comments;
    
    @Column(name = "graded_at", nullable = false, updatable = false)
    private LocalDateTime gradedAt = LocalDateTime.now();
    
    // Constructor vacío
    public StudentMark() {}
    
    // Constructor con parámetros
    public StudentMark(Long quizId, Long studentId, BigDecimal mark, String comments) {
        this.quizId = quizId;
        this.studentId = studentId;
        this.mark = mark;
        this.comments = comments;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getQuizId() {
        return quizId;
    }
    
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public BigDecimal getMark() {
        return mark;
    }
    
    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public LocalDateTime getGradedAt() {
        return gradedAt;
    }
    
    public void setGradedAt(LocalDateTime gradedAt) {
        this.gradedAt = gradedAt;
    }
}
