package com.nhnacademy.subjectweek04.category.entity;

import com.nhnacademy.subjectweek04.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long categoryId;

    @ManyToOne(optional = false)
    private CategoryInfo categoryInfo;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
