
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.service.CourseContentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-contents")
public class CourseContentController {

    private final CourseContentService contentService;
    
    public CourseContentController(CourseContentService contentService) {
        this.contentService = contentService;
    }


    @Operation(summary = "Obtener todos los contenidos de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseContentDTO>> findAll() {
        return ResponseEntity.ok(contentService.findAll());
    }


    @Operation(summary = "Obtener contenido de curso por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CourseContentDTO>> findById(@PathVariable Integer id) {
        CourseContentDTO dto = contentService.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<CourseContentDTO> entityModel = EntityModel.of(dto,
            linkTo(methodOn(CourseContentController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(CourseContentController.class).findAll()).withRel("all-contents")
        );
        return ResponseEntity.ok(entityModel);
    }


    @Operation(summary = "Crear contenido de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseContentDTO> create(@RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(contentService.create(dto));
    }


    @Operation(summary = "Actualizar contenido de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseContentDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseContentDTO dto) {
        return ResponseEntity.ok(contentService.update(id, dto));
    }


    @Operation(summary = "Eliminar contenido de curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
