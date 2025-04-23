package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO #1: join fetch를 사용하도록 쿼리를 작성하세요.
    @Query("select m from Member m left join fetch m.locker")
    List<Member> findAllWithAssociation();
}
