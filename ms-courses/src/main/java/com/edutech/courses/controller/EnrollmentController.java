
package com.edutech.courses.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }


    @Operation(summary = "Obtener todas las inscripciones")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }


    @Operation(summary = "Obtener inscripción por ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public EntityModel<EnrollmentDTO> findById(@PathVariable Integer id) {
        EnrollmentDTO dto = enrollmentService.findById(id);
        return EntityModel.of(dto,
            linkTo(methodOn(EnrollmentController.class).findById(id)).withSelfRel(),
            linkTo(methodOn(EnrollmentController.class).findAll()).withRel("all-enrollments")
        );
    }


    @Operation(summary = "Crear inscripción")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(@RequestBody @Valid EnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.create(dto));
    }


    @Operation(summary = "Actualizar inscripción")
    @ApiResponse(responseCode = "200", description = "OK")
    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Integer id, @RequestBody @Valid EnrollmentDTO dto) {
        return ResponseEntity.ok(enrollmentService.update(id, dto));
    }

    @Operation(summary = "Eliminar inscripción")
    @ApiResponse(responseCode = "200", description = "OK")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        enrollmentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
