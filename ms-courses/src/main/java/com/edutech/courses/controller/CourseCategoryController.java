
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.CourseCategoryDTO;
import com.edutech.courses.service.CourseCategoryService;

import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-categories")
public class CourseCategoryController {

    private final CourseCategoryService categService;
    
    public CourseCategoryController(CourseCategoryService categService) {
        this.categService = categService;
    }


    @Operation(summary = "Obtener todas las categorías")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<CourseCategoryDTO>> findAll() {
        return ResponseEntity.ok(categService.findAll());
    }


    @Operation(summary = "Obtener categoría por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<CourseCategoryDTO> findById(@PathVariable Integer id) {
        CourseCategoryDTO dto = categService.findById(id);
        return EntityModel.of(dto,
            linkTo(methodOn(CourseCategoryController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(CourseCategoryController.class).findAll()).withRel("all-categories")
        );
    }


    @Operation(summary = "Crear categoría")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<CourseCategoryDTO> create(@RequestBody @Valid CourseCategoryDTO dto) {
        return ResponseEntity.ok(categService.create(dto));
    }


    @Operation(summary = "Actualizar categoría")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<CourseCategoryDTO> update(@PathVariable Integer id, @RequestBody @Valid CourseCategoryDTO dto) {
        return ResponseEntity.ok(categService.update(id, dto));
    }


    @Operation(summary = "Eliminar categoría")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            categService.delete(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("No se puede eliminar la categoría porque tiene cursos asociados.");
        }
    }
}
