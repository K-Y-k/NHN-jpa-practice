package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Item;

import java.time.ZonedDateTime;
import java.util.List;

// TODO #1: Custom Repository interface 생성
public interface ItemQuerydslRepository {
    List<Item> findAllByOrderedAtAfter(ZonedDateTime orderedAt);
}
