package com.nhnacademy.subjectweek04.category;

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

    @Column(nullable = false)
    private long categoryInfo;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
