package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import com.nhnacademy.springbootjpa.entity.ItemView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // TODO #1: ItemView를 사용하여 Item 목록을 조회하는 메소드
    List<ItemView> queryAllBy();
}
