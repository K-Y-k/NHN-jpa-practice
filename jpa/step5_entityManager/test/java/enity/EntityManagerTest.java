package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EntityManagerTest {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO #1: 다음 테스트를 실행하면 수행될 쿼리는?
    /// persist() 저장, find() 조회 쿼리가 실행되었지만
    /// 테스트 메서드는 끝날 때 롤백이 발생하여 결국 최종으로 쿼리들이 실행되지 않음
    @Test
    void test1() {
        User user1 = new User("newUser", "abcde");

        /// 엔티티 매니저에 user1을 저장
        entityManager.persist(user1);

        /// 엔티티 매니저에서 저장되어 있는 User를 가져옴
        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #2: 다음 테스트를 실행하면 수행될 쿼리는?
    /// flush가 있으므로 flush전까지 실행된 쿼리가 수행
    @Test
    void test2() {
        User user1 = new User("newUser", "abcde");

        /// 엔티티 매니저에 user1을 저장
        entityManager.persist(user1);
        /// user1을 저장한 쿼리 수행
        entityManager.flush();

        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #3: 다음 테스트를 실행하면 수행될 쿼리는?
    /// flush() 이전의 persist() 저장, set() 변경 쿼리들이 수행된다.
    @Test
    void test3() {
        User user1 = new User("newUser", "abcde");

        /// 엔티티 매니저에 user1을 저장
        entityManager.persist(user1);

        /// 엔티티 매니저에서 저장되어 있는 User를 캐싱으로 가져오므로
        /// 쿼리가 수행되지 않는다.
        User user2 = entityManager.find(User.class, "newUser");
        
        assertThat(user2).isEqualTo(user1);

        /// 객체 필드 변경
        user2.setPassword("fghij");

        /// flush() 이전의 persist() 저장, set() 변경 쿼리들이 수행
        entityManager.flush();
    }

    // TODO #4: 다음 테스트를 실행하면 수행될 쿼리는?
    /// 주어진 코드는 admin에서만 5번 조회하므로
    /// admin 아이디 User는 엔티티 매니저가 아닌 DB에서 조회해야 하므로 1번 find() 쿼리가 실행된다.
    @Sql("entity-manager-test.sql")
    @Test
    void test4() {
        /// 주어진 코드는 admin에서만 5번 조회하므로
        /// admin 아이디 User는 엔티티 매니저가 아닌 DB에서 조회해야 하므로 1번 find() 쿼리가 실행된다.
        User user1 = entityManager.find(User.class, "admin");
        /// JPA가 트랜잭션 내에서는 주소값까지 동일한 객체로 적용해줌 (동일성 보장)
        /// 이 덕분에 편리하게 변경감지 방식이 가능한 것
        User user2 = entityManager.find(User.class, "admin");
        User user3 = entityManager.find(User.class, "admin");
        User user4 = entityManager.find(User.class, "admin");
        User user5 = entityManager.find(User.class, "admin");

        /// 동일성을 보장하고 있다.
        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isEqualTo(user3);
        assertThat(user1).isEqualTo(user4);
        assertThat(user1).isEqualTo(user5);
    }

}
