package com.edutech.courses.controller;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.service.CourseQuizService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/api/course-quizzes")
public class CourseQuizController {

    private final CourseQuizService quizService;
    
    public CourseQuizController(CourseQuizService quizService) {
        this.quizService = quizService;
    }


    @Operation(summary = "Obtener todos los quizzes")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseQuizDTO>> findAll() {
        return ResponseEntity.ok(quizService.findAll());
    }


    @Operation(summary = "Obtener quiz por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<CourseQuizDTO> findById(@PathVariable Integer id) {
        CourseQuizDTO dto = quizService.findById(id);
        return EntityModel.of(dto,
            linkTo(methodOn(CourseQuizController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(CourseQuizController.class).findAll()).withRel("all-quizzes")
        );
    }


    @Operation(summary = "Crear un quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseQuizDTO> create(@RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(quizService.create(dto));
    }


    @Operation(summary = "Actualizar un quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseQuizDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseQuizDTO dto) {
        return ResponseEntity.ok(quizService.update(id, dto));
    }


    @Operation(summary = "Eliminar un quiz")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quizService.delete(id);
        return ResponseEntity.ok().build();
    }
}
