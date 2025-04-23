package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO #1: @EntityGraph를 사용하여 N+1 문제를 해결하세요.
    @EntityGraph(attributePaths = {"locker"})
    List<Member> findAllBy();
}
