package com.nhnacademy.springbootjpa.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.springbootjpa.entity.Item;
import com.nhnacademy.springbootjpa.entity.ItemView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

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
    void queryAllTest() throws JsonProcessingException {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // when
        List<ItemView> itemViews = itemRepository.queryAllBy();

        // then
        assertThat(objectMapper.writeValueAsString(itemViews))
                .isEqualTo("[{\"name\":\"apple\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-23\"},\"quantity\":3}]},"
                        + "{\"name\":\"grape\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-23\"},\"quantity\":1}]},"
                        + "{\"name\":\"banana\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-23\"},\"quantity\":2}]},"
                        + "{\"name\":\"cherry\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":1}]},"
                        + "{\"name\":\"kiwi\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":1}]},"
                        + "{\"name\":\"lemon\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":2}]},"
                        + "{\"name\":\"lime\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":1}]},"
                        + "{\"name\":\"mango\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":5}]},"
                        + "{\"name\":\"orange\",\"orderItems\":[{\"order\":{\"orderedAt\":\"2018-08-24\"},\"quantity\":1}]},"
                        + "{\"name\":\"peach\",\"orderItems\":[]},"
                        + "{\"name\":\"melon\",\"orderItems\":[]}]");
    }

}
