package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

// TODO #2: 아래 `@Disabled` 어노테이션을 삭제하고 테스트를 통과시키세요.
/**
 * 보통 테스트를 전체를 실행해서 돌리는데
 * 현재 아직 완성되지 않았거나 어떤 환경에 대한 세팅이 필요한 테스트인 경우
 * @Disabled를 적용하여 테스트 진행을 건너뛰게할 때 사용한다.
 */
@Disabled("temporary")
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

}
