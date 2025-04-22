package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
