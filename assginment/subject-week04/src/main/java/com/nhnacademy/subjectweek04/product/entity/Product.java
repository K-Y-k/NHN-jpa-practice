package com.nhnacademy.subjectweek04.product.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long productId;

    @Column(nullable = false, length = 255)
    private String productName;

    @Column(length = 255)
    private String productThumbnailImg;

    @Column(length = 255)
    private String productImg;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
