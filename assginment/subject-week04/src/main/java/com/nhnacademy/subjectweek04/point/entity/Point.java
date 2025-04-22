package com.nhnacademy.subjectweek04.point.entity;

import com.nhnacademy.subjectweek04.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pointId;

    @ManyToOne(optional = false)
    private Users user;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, length = 10)
    private PointState pointState;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
