
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.service.CourseCommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-comments")
public class CourseCommentController {

    private final CourseCommentService commentService;
    
    public CourseCommentController(CourseCommentService commentService) {
        this.commentService = commentService;
    }


    @Operation(summary = "Obtener todos los comentarios de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseCommentDTO>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }


    @Operation(summary = "Obtener comentario de curso por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<CourseCommentDTO> findById(@PathVariable Integer id) {
        CourseCommentDTO dto = commentService.findById(id);
        return EntityModel.of(dto,
            linkTo(methodOn(CourseCommentController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(CourseCommentController.class).findAll()).withRel("all-comments")
        );
    }


    @Operation(summary = "Crear comentario de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseCommentDTO> create(@RequestBody @Valid CourseCommentDTO dto) {
        return ResponseEntity.ok(commentService.create(dto));
    }


    @Operation(summary = "Actualizar comentario de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseCommentDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseCommentDTO dto) {
        return ResponseEntity.ok(commentService.update(id, dto));
    }


    @Operation(summary = "Eliminar comentario de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
