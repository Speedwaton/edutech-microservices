package com.edutech.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseQuizQuestionDTO {

    private Integer id;

    @NotNull(message = "Debe especificar el ID del quiz.")
    private Integer quizId;

    @NotBlank(message = "El texto de la pregunta es obligatorio.")
    @Size(max = 800, message = "El texto de la pregunta no puede exceder los 800 caracteres.")
    private String questionText;

    // Opciones de respuesta múltiple
    @Size(max = 800, message = "La opción A no puede exceder los 800 caracteres.")
    private String optionA;

    @Size(max = 800, message = "La opción B no puede exceder los 800 caracteres.")
    private String optionB;

    @Size(max = 800, message = "La opción C no puede exceder los 800 caracteres.")
    private String optionC;

    @Size(max = 800, message = "La opción D no puede exceder los 800 caracteres.")
    private String optionD;

    @Size(max = 800, message = "La opción E no puede exceder los 800 caracteres.")
    private String optionE;

    // Respuesta correcta para preguntas de texto libre
    @Size(max = 800, message = "La respuesta correcta no puede exceder los 800 caracteres.")
    private String correctAnswer;

    // Letra de la opción correcta (A, B, C, D, E)
    @Size(max = 1, message = "La opción correcta debe ser una sola letra.")
    private String correctOption;

    // Orden de la pregunta en el quiz
    @NotNull(message = "Debe especificar el orden de la pregunta.")
    private Integer orderIndex;

    private Instant createdAt;

    private Integer version;

    // Añadimos estos métodos explícitamente para asegurar que existen independientemente de Lombok
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
