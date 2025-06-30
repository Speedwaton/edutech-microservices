package com.edutech.courses.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "course_quiz_question")
public class CourseQuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public void setId(Integer id) { this.id = id; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private CourseQuiz quiz;

    @Column(name = "question_text", length = 800)
    private String questionText;

    @Column(name = "option_a", length = 800)
    private String optionA;

    @Column(name = "option_b", length = 800)
    private String optionB;

    @Column(name = "option_c", length = 800)
    private String optionC;

    @Column(name = "option_d", length = 800)
    private String optionD;

    @Column(name = "option_e", length = 800)
    private String optionE;

    @Column(name = "correct_answer", length = 800)
    private String correctAnswer;

    @Column(name = "correct_option", length = 1)
    private String correctOption;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    // Getters y setters explícitos
    public Integer getId() { return id; }
    
    public CourseQuiz getQuiz() { return quiz; }
    public void setQuiz(CourseQuiz quiz) { this.quiz = quiz; }
    
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    
    public String getOptionA() { return optionA; }
    public void setOptionA(String optionA) { this.optionA = optionA; }
    
    public String getOptionB() { return optionB; }
    public void setOptionB(String optionB) { this.optionB = optionB; }
    
    public String getOptionC() { return optionC; }
    public void setOptionC(String optionC) { this.optionC = optionC; }
    
    public String getOptionD() { return optionD; }
    public void setOptionD(String optionD) { this.optionD = optionD; }
    
    public String getOptionE() { return optionE; }
    public void setOptionE(String optionE) { this.optionE = optionE; }
    
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    
    public String getCorrectOption() { return correctOption; }
    public void setCorrectOption(String correctOption) { this.correctOption = correctOption; }
    
    public Integer getOrderIndex() { return orderIndex; }
    public void setOrderIndex(Integer orderIndex) { this.orderIndex = orderIndex; }
    
    public Instant getCreatedAt() { return createdAt; }
}