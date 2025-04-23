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
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

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


    // TODO #1: 단일 Entity 조회 시
    /**
     * 엔티티 1개를 조회할 때
     * - 즉시 로딩 (Eager Loading)일 때 연관된 엔티티까지 1번의 쿼리로 가져온다.
     * - 지연 로딩 (Lazy Loading)일 때 연관된 엔티티는 실제로 사용할 때 쿼리를 실행한다. 기존 1회 + 이후 사용할 때 1회
     */
    @Sql("order-item-test.sql")
    @Test
    void findByIdTest() {
        itemRepository.findById(1L);
    }


    // TODO #2: 여러 개의 Entity 조회 시
    /**
     * 엔티티 n개를 조회할 때
     * - 지연 로딩 (Lazy Loading) : 제일 골치 아픈 케이스
     *   : 기본 엔티티와 연관된 엔티티를 함께 가져온다. n+1
     *     기본 엔티티 목록 조회 1번 + 각 엔티티의 연관된 엔티티 조회 n번
     * - 지연 로딩 (Lazy Loading)
     *   : 기본 엔티티 목록만 조회하고, 각 엔티티의 연관된 엔티티는 실제 사용 시점에 조회한다. n+1
     *     기본 엔티티 목록 조회 1번 + 각 엔티티의 연관된 엔티티를 사용할 때마다 1번씩 추가(최대 n번)
     */
    @Sql("order-item-test.sql")
    @Test
    void findAllTest() {
        itemRepository.findAll();
    }

    // TODO #3: 여러 개의 Entity 조회 + 객체 그래프 탐색
    @Sql("order-item-test.sql")
    @Test
    void findAllTest2() {
        IntSummaryStatistics statistics = itemRepository.findAll()
                .stream()
                .map(Item::getOrderItems)
                .flatMap(Collection::stream)
                .collect(Collectors.summarizingInt(OrderItem::getQuantity));

        assertThat(statistics.getSum()).isEqualTo(17);
    }

}
