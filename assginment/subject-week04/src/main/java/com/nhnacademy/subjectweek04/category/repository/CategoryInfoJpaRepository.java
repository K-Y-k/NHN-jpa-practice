package com.nhnacademy.subjectweek04.category.repository;

import com.nhnacademy.subjectweek04.category.entity.CategoryInfo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInfoJpaRepository extends JpaRepository<CategoryInfo, Long> {
    // CategoryInfo save(CategoryInfo categoryInfo);
    void deleteByCategoryInfoId(long categoryInfoId);
    Optional<CategoryInfo> findByCategoryInfoId(long categoryInfoId);
    // List<CategoryInfo> findAll();
}
