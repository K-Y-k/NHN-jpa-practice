package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
