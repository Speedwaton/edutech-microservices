package com.edutech.grades.repository;

import com.edutech.grades.entity.StudentMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMarkRepository extends JpaRepository<StudentMark, Long> {
    
    List<StudentMark> findByStudentId(Long studentId);
    
    List<StudentMark> findByQuizId(Long quizId);
    
    List<StudentMark> findByStudentIdAndQuizId(Long studentId, Long quizId);
}
