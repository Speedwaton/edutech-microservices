package com.edutech.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class EnrollmentDTO {
    private Integer id;
    
    @NotNull(message = "Debe especificar el ID del estudiante.")
    private Integer studentId;
    
    @NotNull(message = "Debe especificar el ID del curso.")
    private Integer courseId;
    
    @NotBlank(message = "El estado de la inscripción es obligatorio.")
    private String status;
    
    private Instant enrolledAt;
}
