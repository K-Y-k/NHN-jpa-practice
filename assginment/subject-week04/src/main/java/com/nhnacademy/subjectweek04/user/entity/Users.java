package com.nhnacademy.subjectweek04.user.entity;

import com.nhnacademy.subjectweek04.point.entity.Point;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "user")
public class Users {

    @Id
    @Column(nullable = false, length = 50)
    private String userId;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 200)
    private String userPassword;

    @Column(nullable = false, length = 8)
    private String userBirth;

    @Column(nullable = false, length = 10)
    private Auth userAuth;

    @Column(nullable = false)
    private int userPoint;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime latestLoginAt;

    @OneToMany(mappedBy = "user")
    private List<Point> pointList;

}
