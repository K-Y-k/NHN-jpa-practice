package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

// TODO #1: `item` 테이블과 매핑될 `Item` Entity 클래스를 작성하세요.
/*
 * create table item
 * (
 *     id    bigint auto_increment
 *         primary key,
 *     name  varchar(40) not null,
 *     price bigint      not null
 * );
 */
@Getter
@Entity /// JPA가 관리할 객체임을 명시
public class Item {
    @Id /// 기본 키(PK) 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long price;
}
