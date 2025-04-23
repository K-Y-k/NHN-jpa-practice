package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;

import java.util.List;

// TODO #1: OrderQuerydslRepository 인터페이스 선언
public interface OrderQuerydslRepository {
    // TODO #2: custom 메서드 선언
    List<Item> findAllByHavingOrderItemQuantityGreaterThan(int quantity);
}
