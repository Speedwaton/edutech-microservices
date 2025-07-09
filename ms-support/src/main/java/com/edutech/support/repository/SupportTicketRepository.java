package com.edutech.support.repository;

import com.edutech.support.entity.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    
    List<SupportTicket> findByUserId(Integer userId);
    
    List<SupportTicket> findBySupportUserId(Integer supportUserId);
    
    List<SupportTicket> findByStatus(String status);
    
    List<SupportTicket> findByUserIdAndStatus(Integer userId, String status);
}
