package com.edutech.payments.service;

import com.edutech.common.dto.PaymentDTO;
import com.edutech.payments.entity.Payment;
import com.edutech.payments.mapper.PaymentMapper;
import com.edutech.payments.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    
    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }
    
    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDTO)
                .toList();
    }
    
    public PaymentDTO findById(Integer id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        return paymentMapper.toDTO(payment);
    }
    
    public PaymentDTO create(PaymentDTO dto) {
        Payment payment = paymentMapper.toEntity(dto);
        payment.setId(null); // Para asegurar que es un nuevo registro
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDTO(savedPayment);
    }
    
    public PaymentDTO update(Integer id, PaymentDTO dto) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        
        existingPayment.setUserId(dto.getUserId());
        existingPayment.setAmount(dto.getAmount());
        existingPayment.setPaymentDate(dto.getPaymentDate());
        existingPayment.setPaymentMethod(dto.getPaymentMethod());
        existingPayment.setPaymentInstitution(dto.getPaymentInstitution());
        existingPayment.setTransactionId(dto.getTransactionId());
        existingPayment.setStatus(dto.getStatus());
        
        Payment savedPayment = paymentRepository.save(existingPayment);
        return paymentMapper.toDTO(savedPayment);
    }
    
    public void delete(Integer id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        paymentRepository.delete(payment);
    }
}
