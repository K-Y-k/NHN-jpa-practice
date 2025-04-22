package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByPriceGreaterThanEqual(long price);

    // TODO #1: `@Query`
    @Query("select i from Item i where i.price >= ?1")
    List<Item> findAllByPriceAtLeastByQuery(long price);

    // TODO #2: `@Query` with named parameter
    @Query("select i from Item i where i.price >= :price")
    List<Item> findAllByPriceAtLeastByQueryParam(long price);

    // TODO #3: `@Query` with native query
    @Query(value = "select * from item where price >= ?1", nativeQuery = true)
    List<Item> findAllByPriceAtLeastByNativeQuery(long price);

    // TODO #4: `@Query` with native query and named parameter
    @Query(value = "select * from item where price >= :price", nativeQuery = true)
    List<Item> findAllByPriceAtLeastByNativeQueryParam(long price);

    // TODO #5: `@Modifying`
    @Modifying
    @Query("update Item i set i.name = :name where i.id = :id")
    int updateNameByIdByQuery(long id, String name);

    // TODO #6: `@Modifying` with `clearAutomatically`
    @Modifying(clearAutomatically = true)
    @Query("update Item i set i.name = :name where i.id = :id")
    int updateNameByIdByQueryAndClear(long id, String name);
}
