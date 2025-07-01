
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.service.CourseQuizQuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-quiz-questions")
public class CourseQuizQuestionController {

    private final CourseQuizQuestionService questionService;
    
    public CourseQuizQuestionController(CourseQuizQuestionService questionService) {
        this.questionService = questionService;
    }


    @Operation(summary = "Obtener todas las preguntas de quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseQuizQuestionDTO>> findAll() {
        return ResponseEntity.ok(questionService.findAll());
    }


    @Operation(summary = "Obtener pregunta de quiz por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<CourseQuizQuestionDTO> findById(@PathVariable Integer id) {
        CourseQuizQuestionDTO dto = questionService.findById(id);
        return EntityModel.of(dto,
            linkTo(methodOn(CourseQuizQuestionController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(CourseQuizQuestionController.class).findAll()).withRel("all-questions")
        );
    }


    @Operation(summary = "Crear pregunta de quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseQuizQuestionDTO> create(@RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(questionService.create(dto));
    }


    @Operation(summary = "Actualizar pregunta de quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizQuestionDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseQuizQuestionDTO dto) {
        return ResponseEntity.ok(questionService.update(id, dto));
    }

    @Operation(summary = "Eliminar pregunta de quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        questionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
