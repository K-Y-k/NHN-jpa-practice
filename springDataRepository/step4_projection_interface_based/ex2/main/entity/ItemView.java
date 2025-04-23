package com.nhnacademy.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

public interface ItemView {

    String getName();

    List<OrderItemView> getOrderItems();

    interface OrderItemView {
        OrderView getOrder();

        int getQuantity();
    }

    interface OrderView {
        @JsonFormat(pattern = "yyyy-MM-dd")
        ZonedDateTime getOrderedAt();
    }
}
