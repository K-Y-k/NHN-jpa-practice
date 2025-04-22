package com.nhnacademy.subjectweek04.product.repository;

import com.nhnacademy.subjectweek04.product.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    // Product save(Product product);
    void deleteByProductId(long productId);
    Optional<Product> findByProductId(long productId);

    // List<Product> findAll();
    List<Product> findAllByProductName(String searchKeyword);

    long countAll();
    @Query("select count(distinct p) from Product p join Category c ON c.product = p where c.categoryInfo.categoryInfoId = :categoryInfoId")
    long totalCountByCategoryInfoId(long categoryInfoId);

    @Query("select distinct p from Product p join Category c on c.product = p " +
           "where (:categoryInfoId = 0 OR c.categoryInfo.categoryInfoId = :categoryInfoId) " +
           "AND (:searchKeyword IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :searchKeyword, '%')))")
    Page<Product> findBySearchCondition(int categoryInfoId, String searchKeyword, Pageable pageable);
}
