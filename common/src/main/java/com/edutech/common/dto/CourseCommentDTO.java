package com.edutech.common.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseCommentDTO {

    private Integer id;

    @NotNull(message = "Debe especificar el ID del curso.")
    private Integer courseId;

    @NotNull(message = "Debe especificar el ID del usuario.")
    private Integer userId;

    @NotBlank(message = "El texto del comentario es obligatorio.")
    @Size(max = 800, message = "El comentario no puede exceder los 800 caracteres.")
    private String commentText;

    @NotNull(message = "Debe especificar una calificación.")
    @Min(value = 0, message = "La calificación mínima es 0.")
    @Max(value = 5, message = "La calificación máxima es 5.")
    private Integer rating;

    private Instant createdAt;

    // Métodos explícitos para todos los campos para evitar problemas con Lombok
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    // Alias para mantener compatibilidad
    public void setText(String text) {
        this.commentText = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}