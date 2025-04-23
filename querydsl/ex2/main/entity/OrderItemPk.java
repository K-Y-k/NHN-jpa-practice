package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class OrderItemPk implements Serializable {
    private long orderId;
    private int lineNumber;
}
