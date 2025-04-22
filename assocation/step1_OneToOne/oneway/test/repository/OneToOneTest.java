package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Locker;
import com.nhnacademy.springbootjpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// TODO #3: test case
@DataJpaTest
class OneToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        Locker locker = new Locker(1L, "No.1 Locker");
        lockerRepository.save(locker);

        Member member = new Member(1L, "academy", locker);
        memberRepository.save(member);

        entityManager.flush();
    }
}
