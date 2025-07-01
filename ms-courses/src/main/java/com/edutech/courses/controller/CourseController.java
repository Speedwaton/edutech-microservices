
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.CourseDTO;
import com.edutech.courses.service.CourseService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @Operation(summary = "Obtener todos los cursos")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }


    @Operation(summary = "Obtener curso por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<CourseDTO> findById(@PathVariable Integer id) {
        CourseDTO courseDTO = courseService.findById(id);
        return EntityModel.of(courseDTO,
                linkTo(methodOn(CourseController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(CourseController.class).findAll()).withRel("all-courses"));
    }


    @Operation(summary = "Crear curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody @Valid CourseDTO dto) {
        return ResponseEntity.ok(courseService.create(dto));
    }


    @Operation(summary = "Actualizar curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseDTO dto) {
        return ResponseEntity.ok(courseService.update(id, dto));
    }


    @Operation(summary = "Eliminar curso")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
