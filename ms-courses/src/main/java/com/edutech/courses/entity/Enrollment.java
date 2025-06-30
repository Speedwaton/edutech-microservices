package com.edutech.courses.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;
    
    @Column(name = "course_id", nullable = false)
    private Integer courseId;
    
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "enrolled_at", nullable = false)
    private Instant enrolledAt;
    
    // Constructors
    public Enrollment() {
    }
    
    @PrePersist
    public void prePersist() {
        if (this.enrolledAt == null) {
            this.enrolledAt = Instant.now();
        }
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(Instant enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
