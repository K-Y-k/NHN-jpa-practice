package com.nhnacademy.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// TODO #2: `OrderItem` Entity 클래스의 복합키 클래스인 `OrderItemPk` 클래스를 작성하세요.
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItemPk implements Serializable {
    private Long orderId;
    private Integer lineNumber;
}

