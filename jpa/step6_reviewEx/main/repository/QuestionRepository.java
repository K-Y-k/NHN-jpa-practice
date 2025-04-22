package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
