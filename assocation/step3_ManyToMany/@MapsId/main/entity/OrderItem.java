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
    // 복합 키를 사용한 경우, 하지만 인조 단일 키 방식으로 적용 권장
    @EmbeddedId
    private OrderItemPk pk;

    // TODO #1: 다대일 관계 설정
    @MapsId("orderId")
    @ManyToOne(optional = false)
    private Order order;

    @ManyToOne(optional = false)
    private Item item;

    private int quantity;
}
