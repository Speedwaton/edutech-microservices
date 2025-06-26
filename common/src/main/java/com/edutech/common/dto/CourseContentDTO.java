package com.edutech.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseContentDTO {
    private Integer id;
    
    @NotBlank(message = "El título del contenido es obligatorio.")
    @Size(max = 200, message = "El título no puede exceder los 200 caracteres.")
    private String title;
    
    @NotBlank(message = "La descripción del contenido es obligatoria.")
    @Size(max = 800, message = "La descripción no puede exceder los 800 caracteres.")
    private String description;
    
    @NotNull(message = "Debe especificar el ID del curso.")
    private Integer courseId;
    
    @NotNull(message = "Debe especificar el orden del contenido.")
    private Integer orderIndex;
    
    @NotBlank(message = "La URL del contenido es obligatoria.")
    private String url;
    
    @NotBlank(message = "El tipo de contenido es obligatorio.")
    @Size(max = 50, message = "El tipo de contenido no puede exceder los 50 caracteres.")
    private String contentType;
    
    private Integer duration; // Duración en segundos (opcional)
    
    private Integer version;
    
    // Añadimos estos métodos explícitamente para asegurar que existen independientemente de Lombok
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
}
