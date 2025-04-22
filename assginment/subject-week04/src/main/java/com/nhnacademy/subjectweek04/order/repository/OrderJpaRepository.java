package com.nhnacademy.subjectweek04.order.repository;

import com.nhnacademy.subjectweek04.order.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Orders, Long> {
    // Orders save(Orders orders);
    List<Orders> findAllByUser_UserId(String userId);
    Orders findByOrderId(long orderId);
}
