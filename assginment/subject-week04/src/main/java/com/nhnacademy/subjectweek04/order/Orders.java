package com.nhnacademy.subjectweek04.order;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long orderId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 20)
    private OrderState orderStatus;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false)
    private LocalDateTime orderDate;

}
