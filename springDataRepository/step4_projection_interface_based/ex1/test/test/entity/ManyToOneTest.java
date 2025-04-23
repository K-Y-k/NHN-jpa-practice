package com.nhnacademy.springbootjpa.entity;

import com.nhnacademy.springbootjpa.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO #2: test case
@DataJpaTest
class ManyToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        Member member = new Member("academy");
        member.addPost(new Post("제목 제목1", "내용 내용1", member));
        member.addPost(new Post("제목 제목2", "내용 내용2", member));

        memberRepository.save(member);

        entityManager.flush();
    }
}
