package com.edutech.grades.controller;

import com.edutech.grades.service.StudentMarkService;
import com.edutech.common.dto.StudentMarkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-marks")
public class StudentMarkController {
    
    @Autowired
    private StudentMarkService service;
    
    @GetMapping
    public ResponseEntity<List<StudentMarkDTO>> getAllStudentMarks() {
        List<StudentMarkDTO> marks = service.getAllStudentMarks();
        return ResponseEntity.ok(marks);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudentMarkDTO> getStudentMarkById(@PathVariable Long id) {
        Optional<StudentMarkDTO> mark = service.getStudentMarkById(id);
        return mark.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentMarkDTO>> getStudentMarksByStudentId(@PathVariable Long studentId) {
        List<StudentMarkDTO> marks = service.getStudentMarksByStudentId(studentId);
        return ResponseEntity.ok(marks);
    }
    
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<StudentMarkDTO>> getStudentMarksByQuizId(@PathVariable Long quizId) {
        List<StudentMarkDTO> marks = service.getStudentMarksByQuizId(quizId);
        return ResponseEntity.ok(marks);
    }
    
    @PostMapping
    public ResponseEntity<StudentMarkDTO> createStudentMark(@RequestBody StudentMarkDTO dto) {
        try {
            StudentMarkDTO created = service.createStudentMark(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentMarkDTO> updateStudentMark(@PathVariable Long id, @RequestBody StudentMarkDTO dto) {
        Optional<StudentMarkDTO> updated = service.updateStudentMark(id, dto);
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentMark(@PathVariable Long id) {
        if (service.deleteStudentMark(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
