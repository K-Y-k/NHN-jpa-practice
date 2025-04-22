package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.OrderItem;
import com.nhnacademy.springbootjpa.entity.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

/// 복합 키를 넣음
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
