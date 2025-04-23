package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Sql("order-test.sql")
    @Test
    void findOrderTest() {
        // given
        // when
        List<Order> orders = orderRepository.findAll();

        // then
        assertThat(orders).hasSize(2);
    }

}
