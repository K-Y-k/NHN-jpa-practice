package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Sql("order-test.sql")
    @Test
    void findOrderTest() {
        // given
        long id = 1L;

        // when
        Order order = orderRepository.findById(id).orElse(null);

        // then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isEqualTo(id);
        assertThat(order.getOrderedAt()).isEqualTo(ZonedDateTime.parse("2018-08-23T10:30:00+09:00"));
    }

    // TODO #2: test case 를 통과시키세요.
    @Sql("order-test.sql")
    @Test
    void test() {
        ZonedDateTime orderedAt = ZonedDateTime.parse("2018-08-24T00:00:00+09:00");
        assertThat(orderRepository.findAllByOrderedAtAfter(orderedAt)).hasSize(1);
        assertThat(orderRepository.findAllByOrderedAtAfterByQuery(orderedAt)).hasSize(1);
    }

}
