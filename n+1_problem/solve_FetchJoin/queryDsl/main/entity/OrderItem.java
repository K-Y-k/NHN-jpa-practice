package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemPk pk;

    @MapsId("orderId")
    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private Item item;

    private int quantity;
}
