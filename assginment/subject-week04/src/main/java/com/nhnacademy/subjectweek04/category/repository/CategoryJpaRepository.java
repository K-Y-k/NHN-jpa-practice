package com.nhnacademy.subjectweek04.category.repository;

import com.nhnacademy.subjectweek04.category.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    // Category save(Category category);
    void deleteByProduct_ProductId(long productId);
    List<Category> findAllByProduct_ProductId(long productId);
}
