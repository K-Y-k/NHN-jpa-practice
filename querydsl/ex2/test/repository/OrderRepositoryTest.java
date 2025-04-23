package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
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

    // TODO #7: 실습 - 6번 항목까지 모두 완료하였으면 아래 테스트를 통과시키세요.
    @Test
    void test() {
        List<Item> items1 = orderRepository.findAllByHavingOrderItemQuantityGreaterThan(4);
        assertThat(items1).hasSize(1);

        List<Item> items2 = orderRepository.findAllByHavingOrderItemQuantityGreaterThan(1);
        assertThat(items2).hasSize(4);
    }

}
