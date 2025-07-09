package com.edutech.payments.controller;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    
    private final PaymentService paymentService;
    
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<PaymentDTO> create(@RequestBody @Valid PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.create(dto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> update(@PathVariable Integer id, @RequestBody @Valid PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.update(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
