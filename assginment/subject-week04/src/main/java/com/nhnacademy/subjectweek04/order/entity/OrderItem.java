package com.nhnacademy.subjectweek04.order.entity;

import com.nhnacademy.subjectweek04.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long orderItemId;

    @ManyToOne(optional = false)
    private Orders order;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int totalPrice;

}
