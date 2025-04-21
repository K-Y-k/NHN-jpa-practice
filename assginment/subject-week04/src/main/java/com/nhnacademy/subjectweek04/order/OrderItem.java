package com.nhnacademy.subjectweek04.order;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long orderItemId;

    @Column(nullable = false)
    private long orderId;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int totalPrice;

}
