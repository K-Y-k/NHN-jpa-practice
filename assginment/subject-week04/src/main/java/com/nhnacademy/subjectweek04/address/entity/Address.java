package com.nhnacademy.subjectweek04.address.entity;

import com.nhnacademy.subjectweek04.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long addressId;

    @ManyToOne(optional = false)
    private Users user;

    @Column(nullable = false, length = 255)
    private String addressName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
