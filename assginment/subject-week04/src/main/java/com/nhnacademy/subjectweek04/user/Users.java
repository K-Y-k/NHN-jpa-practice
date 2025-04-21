package com.nhnacademy.subjectweek04.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
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

}
