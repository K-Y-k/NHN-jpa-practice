package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import com.nhnacademy.springbootjpa.entity.MemberGreetingView;
import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.entity.MemberView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /// 닫힌 프로젝션 인터페이스를 반환하는 쿼리 메소드
    MemberNameOnlyView queryById(long id);

    /// 열린 프로젝션 인터페이스를 반환하는 쿼리 메소드
    MemberGreetingView readById(long id);

    /// 중첩 구조를 갖는 프로젝션 인터페이스를 반환하는 쿼리 메소드
    List<MemberView> findAllByName(String name);

    /**
     * 반환 타입을 프로젝션으로 적용한 Page
     *
     * - findAll로 지정한 경우
     *   findAll은 기존에 제공되는 메소드로
     *   호출 부분만 다르면 오버로딩이 가능한데
     *   반환 부분이 다르면 충돌이 일어난다. (현재 반환 타입이 MemberNameOnlyView로 다름)
     *
     * - 다른 명칭으로 지정한 경우
     *   By까지의 명칭으로 지정해야
     */
    Page<MemberNameOnlyView> readAllBy(Pageable pageable);
}
