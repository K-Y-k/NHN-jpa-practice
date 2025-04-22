package com.nhnacademy.subjectweek04.order.repository;

import com.nhnacademy.subjectweek04.order.entity.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {
    // OrderItem save(OrderItem orderItem);
    List<OrderItem> findAllByOrder_OrderId(long orderId);
}
