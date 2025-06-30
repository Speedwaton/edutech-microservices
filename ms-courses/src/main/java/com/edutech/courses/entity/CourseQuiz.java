package com.edutech.courses.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "course_quiz")
public class CourseQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public void setId(Integer id) { this.id = id; }

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", nullable = false, length = 800)
    private String description;

    @Column(name = "quiz_type", nullable = false, length = 50)
    private String quizType;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseQuizQuestion> questions;

    // Getters y setters explícitos
    public Integer getId() { return id; }
    
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getQuizType() { return quizType; }
    public void setQuizType(String quizType) { this.quizType = quizType; }
    
    public Instant getCreatedAt() { return createdAt; }
    
    public List<CourseQuizQuestion> getQuestions() { return questions; }
    public void setQuestions(List<CourseQuizQuestion> questions) { this.questions = questions; }
}