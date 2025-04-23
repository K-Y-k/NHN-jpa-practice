package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Sql("order-item-test.sql")
    @Test
    void test() {
        // given
        ZonedDateTime orderedAt = ZonedDateTime.parse("2018-08-23T10:30:00+09:00");

        // when
        List<Item> items = itemRepository.findAllByOrderedAtAfter(orderedAt);

        // then
        assertThat(items).hasSize(6);
    }

}
