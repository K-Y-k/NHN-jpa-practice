package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.ZonedDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderedAtAfter(ZonedDateTime orderedAt);

    // TODO #1: `@Query`를 이용해서 위의 `findAllByOrderedAtAfter()` 메서드와 동일한 기능을 하도록 JPQL을 작성하세요.
    @Query("select o from Order o where o.orderedAt > :orderedAt")
    List<Order> findAllByOrderedAtAfterByQuery(ZonedDateTime orderedAt);
}
