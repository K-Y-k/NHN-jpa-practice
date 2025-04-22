package com.nhnacademy.subjectweek04.order.entity;

import com.nhnacademy.subjectweek04.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "order")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long orderId;

    @ManyToOne(optional = false)
    private Users user;

    @Column(nullable = false, length = 20)
    private OrderState orderStatus;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false)
    private LocalDateTime orderDate;

}
