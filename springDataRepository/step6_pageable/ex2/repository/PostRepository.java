package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
