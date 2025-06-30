package com.edutech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.courses.entity.CourseQuizQuestion;

@Repository
public interface CourseQuizQuestionRepository extends JpaRepository<CourseQuizQuestion, Integer> {

}
