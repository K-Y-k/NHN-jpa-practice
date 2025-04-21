package com.nhnacademy.subjectweek04.category;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class CategoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long categoryInfoId;

    @Column(nullable = false, length = 255)
    private String categoryName;

}
