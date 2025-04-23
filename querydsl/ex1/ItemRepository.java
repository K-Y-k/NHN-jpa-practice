package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO #3: 기본 Repository interface가 Custom Repository interface를 상속받도록 변경
public interface ItemRepository extends JpaRepository<Item, Long>, ItemQuerydslRepository {
}
