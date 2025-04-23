package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Locker;
import com.nhnacademy.springbootjpa.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OneToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("양방향 연관 관계 테스트 - 영속성 초기화하지 않고 조회")
    @Test
    void test001() {
        // Member를 생성할 때는 Locker가 없기 때문에 null로 설정합니다.
        Member member = new Member(1L, "academy", null);
        memberRepository.save(member);

        // Locker를 생성할 때는 Member가 있기 때문에 Member를 설정합니다.
        Locker locker = new Locker(1L, "No.1 Locker", member);
        lockerRepository.save(locker);

        // flush()를 호출하여 영속성 컨텍스트를 DB에 반영합니다.
        entityManager.flush();

        // 저장된 Member와 Locker를 조회합니다. 영속성 컨텍스트를 초기화하지 않았기 때문에 위에서 저장한 Member와 Locker가 그대로 조회됩니다.
        Member foundMember = memberRepository.findById(1L).orElse(null);
        Locker foundLocker = lockerRepository.findById(1L).orElse(null);

        // 양방향 연관관계가 설정되었는지 확인합니다.
        assertThat(foundMember).isNotNull();
        assertThat(foundLocker).isNotNull();
        assertThat(foundLocker.getMember()).isEqualTo(foundMember);
    }

    @DisplayName("양방향 연관 관계 테스트 - 영속성 초기화 후 조회")
    @Test
    void test002() {
        // Member를 생성할 때는 Locker가 없기 때문에 null로 설정합니다.
        Member member = new Member(1L, "academy", null);
        memberRepository.save(member);

        // Locker를 생성할 때는 Member가 있기 때문에 Member를 설정합니다.
        Locker locker = new Locker(1L, "No.1 Locker", member);
        lockerRepository.save(locker);

        // flush()를 호출하여 영속성 컨텍스트를 DB에 반영합니다.
        entityManager.flush();

        // entityManager.clear()를 호출하여 영속성 컨텍스트를 초기화합니다.
        entityManager.clear();

        // 영속성 컨텍스트를 초기화했기 때문에 DB에서 다시 조회합니다.
        Member foundMember = memberRepository.findById(1L).orElse(null);
        Locker foundLocker = lockerRepository.findById(1L).orElse(null);

        // 양방향 연관관계가 설정되었는지 확인합니다.
        assertThat(foundMember).isNotNull();
        assertThat(foundLocker).isNotNull();
        assertThat(foundLocker.getMember()).isEqualTo(foundMember);
        assertThat(foundMember.getLocker()).isEqualTo(foundLocker);
    }
}
