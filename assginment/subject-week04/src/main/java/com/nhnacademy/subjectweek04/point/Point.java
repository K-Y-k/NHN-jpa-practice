package com.nhnacademy.subjectweek04.point;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pointId;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, length = 10)
    private PointState pointState;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
