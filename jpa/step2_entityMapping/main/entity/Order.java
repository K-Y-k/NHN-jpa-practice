package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.ZonedDateTime;

// TODO #1: `order` 테이블과 매핑될 `Order` Entity 클래스를 작성하세요.
/*
 * create table "order"
 * (
 *     id         bigint auto_increment
 *         primary key,
 *     ordered_at datetime not null
 * );
 */
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime orderedAt;
}
