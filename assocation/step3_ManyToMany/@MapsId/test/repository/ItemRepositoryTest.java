package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Sql("item-test.sql")
    @Test
    void findItemTest() {
        // given
        long itemId = 1L;

        // when
        Item item = itemRepository.findById(itemId).orElse(null);

        // then
        assertThat(item).isNotNull();
        assertThat(item.getId()).isEqualTo(itemId);
        assertThat(item.getName()).isEqualTo("apple");
        assertThat(item.getPrice()).isEqualTo(300L);
    }

    @DisplayName("findById 실행 쿼리 살펴보기")
    @Sql("order-item-test.sql")
    @Test
    void findByIdTest() {
        Item item = itemRepository.findById(1L).orElse(null);
        assertNotNull(item);
        assertThat(item.getId()).isEqualTo(1L);
    }

    // TODO #3: test case
    @DisplayName("findAllByOrderItemsQuantityGreaterThan 실행 쿼리 살펴보기 - 1차 탐색")
    @Sql("order-item-test.sql")
    @Test
    void findAllByOrderItemsQuantityGreaterThanTest() {
        List<Item> items = itemRepository.findAllByOrderItemsQuantityGreaterThan(4);
        assertThat(items).hasSize(1);
    }

    // TODO #4: test case
    @DisplayName("findAllByOrderItemsOrderOrderedAtAfter 실행 쿼리 살펴보기 - 2차 탐색")
    @Sql("order-item-test.sql")
    @Test
    void findAllByOrderItemsOrderOrderedAtAfterTest() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-08-23T10:30:00+09:00");
        List<Item> items = itemRepository.findAllByOrderItemsOrderOrderedAtAfter(zonedDateTime);
        assertThat(items).hasSize(6);
    }

}
