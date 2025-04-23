package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import com.nhnacademy.springbootjpa.entity.Order;
import com.nhnacademy.springbootjpa.entity.OrderItem;
import com.nhnacademy.springbootjpa.entity.OrderItemPk;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Sql("order-item-test.sql")
    @Test
    void findOrderItemTest() {
        // given
        long orderId = 1;
        int lineNumber = 1;
        OrderItemPk orderItemPk = new OrderItemPk(orderId, lineNumber);

        // when
        OrderItem orderItem = orderItemRepository.findById(orderItemPk).orElse(null);

        // then
        assertThat(orderItem).isNotNull();
        assertThat(orderItem.getPk().getOrderId()).isEqualTo(orderId);
        assertThat(orderItem.getPk().getLineNumber()).isEqualTo(lineNumber);
        assertThat(orderItem.getItem().getId()).isEqualTo(1L);
        assertThat(orderItem.getQuantity()).isEqualTo(3);
    }

    @Test
    void saveTest() {
        Item item1 = itemRepository.save(new Item("item1", 1000L));
        Item item2 = itemRepository.save(new Item("item2", 2000L));
        Order order = orderRepository.save(new Order(ZonedDateTime.now()));

        OrderItem orderItem1 = orderItemRepository.save(
                new OrderItem(
                        new OrderItemPk(order.getId(), 1),
                        order,
                        item1,
                        10
                )
        );

        OrderItem orderItem2 = orderItemRepository.save(
                new OrderItem(
                        new OrderItemPk(order.getId(), 2),
                        order,
                        item2,
                        3
                )
        );

        entityManager.flush();
    }

}
