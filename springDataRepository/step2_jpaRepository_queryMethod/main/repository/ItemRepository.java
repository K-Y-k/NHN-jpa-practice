package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // select *
    // from item
    // where name like '{name}'
    List<Item> findAllByNameLike(String name);

    // select id
    // from item
    // where name = '{name}'
    //   and price = {price}
    // limit 1
    boolean existsByNameAndPrice(String itemName, long price);

    // select count(*)
    // from item
    // where name like '%{name}%'
    int countByNameLike(String name);

    // delete
    // from item
    // where price between {price1} and {price2}
    void deleteAllByPriceBetween(long price1, long price2);

    // TODO : #1 실습 - 아래 쿼리 결과가 나오도록 메서드를 추가하세요.
    // select *
    // from item
    // where price in (...)
    List<Item> findAllByPriceIn(List<Long> prices);
}
