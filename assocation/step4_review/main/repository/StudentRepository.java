package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
