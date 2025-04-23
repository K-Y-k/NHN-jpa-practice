package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import com.nhnacademy.springbootjpa.entity.MemberGreetingView;
import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.entity.MemberView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /// 프로젝션은 Repository 메서드가 Entity를 반환하는 것이 아니라 원하는 필드만 뽑아서 반환하는 기능이다.
    /// 리소스에 사용하지 않는 필드를 제외함으로써 비용을 줄이기 위함이다
    // TODO #2: 닫힌 프로젝션 인터페이스를 반환하는 쿼리 메소드
    MemberNameOnlyView queryById(long id);

    // TODO #5: 열린 프로젝션 인터페이스를 반환하는 쿼리 메소드
    MemberGreetingView readById(long id);

    // TODO #8: 중첩 구조를 갖는 프로젝션 인터페이스를 반환하는 쿼리 메소드
    List<MemberView> findAllByName(String name);
}
