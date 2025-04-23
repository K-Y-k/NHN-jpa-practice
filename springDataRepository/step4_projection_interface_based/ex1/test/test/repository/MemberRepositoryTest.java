package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.MemberGreetingView;
import com.nhnacademy.springbootjpa.entity.MemberNameOnlyView;
import com.nhnacademy.springbootjpa.entity.MemberView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    // TODO #3: queryById 테스트
    @DisplayName("닫힌 프로젝션 쿼리 메소드 실행 쿼리 살펴보기")
    @Sql("member-test.sql")
    @Test
    void queryByIdTest() {
        // given
        long id = 1;

        // when
        MemberNameOnlyView memberNameOnlyView = memberRepository.queryById(id);

        // then
        assertThat(memberNameOnlyView).isNotNull();
        assertThat(memberNameOnlyView.getName()).isEqualTo("nhn");
    }

    // TODO #6: readById 테스트
    @DisplayName("열린 프로젝션 쿼리 메소드 실행 쿼리 살펴보기")
    @Sql("member-test.sql")
    @Test
    void readByIdTest() {
        // given
        long id = 1;

        // when
        MemberGreetingView member = memberRepository.readById(id);

        // then
        assertThat(member).isNotNull();
        assertThat(member.getSalutation()).isEqualTo("Hello, nhn!");
    }

    // TODO #9: findAllByName 테스트
    @DisplayName("중첩 구조를 갖는 프로젝션 쿼리 메소드 실행 쿼리 살펴보기")
    @Sql("member-test.sql")
    @Test
    void findAllByNameTest() {
        // given
        String name = "nhn";

        // when
        List<MemberView> memberViews = memberRepository.findAllByName(name);

        // then
        assertThat(memberViews).hasSize(1);
        assertThat(memberViews.getFirst().getPosts()).hasSize(3);
        assertThat(memberViews.getFirst().getPosts().getFirst().getTitle()).isEqualTo("title1");
        assertThat(memberViews.getFirst().getPosts().getFirst().getContent()).isEqualTo("content1");
    }

}
