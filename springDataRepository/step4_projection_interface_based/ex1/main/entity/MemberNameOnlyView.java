package com.nhnacademy.springbootjpa.entity;

// TODO #1: 닫힌 프로젝션을 위한 `MemberNameOnlyView` 인터페이스
// 프로젝션은 Repository 메서드가 Entity를 반환하는 것이 아니라 원하는 필드만 뽑아서 반환하는 기능이다.
public interface MemberNameOnlyView {
    String getName();
}
