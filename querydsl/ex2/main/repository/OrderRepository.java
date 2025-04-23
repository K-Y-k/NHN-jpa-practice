package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #6 실습 - 기본 repository가 custom repository를 상속받도록 수정하세요.
public interface OrderRepository extends JpaRepository<Order, Long>, OrderQuerydslRepository {
}
