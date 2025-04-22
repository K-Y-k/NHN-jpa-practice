package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
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

    @PersistenceContext
    private EntityManager entityManager;

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

    // TODO #7: test case (@Query를 사용한 조회 메소드)
    @DisplayName("@Query를 사용한 조회 메소드 테스트")
    @Sql("item-test.sql")
    @Test
    void queryTest() {
        // JpaRepository 메소드 이름 규칙을 사용한 조회 메소드
        List<Item> items1 = itemRepository.findAllByPriceGreaterThanEqual(250L);
        assertThat(items1).hasSize(7);

        // @Query 어노테이션을 사용한 조회 메소드
        List<Item> items2 = itemRepository.findAllByPriceAtLeastByQuery(250L);
        assertThat(items2).hasSize(7);

        // @Query 어노테이션을 사용한 조회 메소드 (Named Parameter)
        List<Item> items3 = itemRepository.findAllByPriceAtLeastByQueryParam(250L);
        assertThat(items3).hasSize(7);
    }

    // TODO #8: test case (Native Query를 사용한 조회 메소드)
    @DisplayName("@Query와 Native Query를 사용한 조회 메소드 테스트")
    @Sql("item-test.sql")
    @Test
    void nativeQueryTest() {
        // JpaRepository 메소드 이름 규칙을 사용한 조회 메소드
        List<Item> items1 = itemRepository.findAllByPriceGreaterThanEqual(250L);
        assertThat(items1).hasSize(7);

        // @Query 어노테이션과 nativeQuery 속성을 사용한 조회 메소드
        List<Item> items2 = itemRepository.findAllByPriceAtLeastByNativeQuery(250L);
        assertThat(items2).hasSize(7);

        // @Query 어노테이션과 nativeQuery 속성을 사용한 조회 메소드 (Named Parameter)
        List<Item> items3 = itemRepository.findAllByPriceAtLeastByNativeQueryParam(250L);
        assertThat(items3).hasSize(7);
    }

    // TODO #9: test case (@Modifying을 사용한 업데이트 메소드)
    @DisplayName("@Modifying을 사용한 업데이트 메소드 테스트")
    @Sql("item-test.sql")
    @Test
    void updateQueryTest() {
        // given
        long itemId = 1L;

        // when
        Item item1 = itemRepository.findById(itemId).orElse(null);

        // then - 변경 전 name = apple
        assertThat(item1).isNotNull();
        assertThat(item1.getName()).isEqualTo("apple");

        // when - @Modifying @Query 로 name 변경, name = samsung
        itemRepository.updateNameByIdByQuery(itemId, "samsung");

        // then - 바로 조회하면, 변경된 name = samsung이 아닌 이전 name = apple이 조회됨, 영속성 컨텍스트에는 아까 조회한 item1이 남아있음
        Item item2 = itemRepository.findById(itemId).orElse(null);
        assertThat(item2).isNotNull();
        assertThat(item2.getName()).isNotEqualTo("samsung");
        assertThat(item2.getName()).isEqualTo("apple");

        // when - 영속성 컨텍스트를 초기화하고 다시 조회하면, 변경된 name = samsung이 조회됨
        entityManager.clear();
        item2 = itemRepository.findById(itemId).orElse(null);

        // then
        assertThat(item2).isNotNull();
        assertThat(item2.getName()).isEqualTo("samsung");
    }

    // TODO #10: test case (@Modifying을 사용한 업데이트 메소드, clearAutomatically = true)
    @DisplayName("@Modifying을 사용한 업데이트 메소드 테스트, clearAutomatically = true")
    @Sql("item-test.sql")
    @Test
    void updateQueryAndClearTest() {
        // given
        long itemId = 1L;

        // when
        Item item1 = itemRepository.findById(itemId).orElse(null);

        // then - 변경 전, name = apple
        assertThat(item1).isNotNull();
        assertThat(item1.getName()).isEqualTo("apple");

        // when - @Modifying(clearAutomatically = true) @Query 로 name 변경, name = samsung
        itemRepository.updateNameByIdByQueryAndClear(itemId, "samsung");

        // then - 바로 조회하면, 변경된 name = samsung이 조회됨, clearAutomatically 옵션에 의해 영속성 컨텍스트가 자동으로 초기화됨
        Item item2 = itemRepository.findById(itemId).orElse(null);
        assertThat(item2).isNotNull();
        assertThat(item2.getName()).isEqualTo("samsung");
    }

}
