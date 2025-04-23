package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import com.nhnacademy.springbootjpa.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

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

    // TODO #2: test case
    @Sql("order-item-test.sql")
    @Test
    void findAllByFetchJoinTest() {
        IntSummaryStatistics statistics = itemRepository.findAllBy()
                .stream()
                .map(Item::getOrderItems)
                .flatMap(Collection::stream)
                .collect(Collectors.summarizingInt(OrderItem::getQuantity));

        assertThat(statistics.getSum()).isEqualTo(17);
    }
}
