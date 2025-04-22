package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
