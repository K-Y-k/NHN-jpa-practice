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

// TODO #2: test case 수정
@DataJpaTest
class OneToOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * 양방향의 문제점
     */
    @DisplayName("양방향 연관 관계 테스트 - 영속성 초기화하지 않고 조회")
    @Test
    void test001() {
        // Member를 생성할 때는 Locker가 없기 때문에 null로 설정합니다.
        /// Locker 필드가 mappedBy이므로 책임이 없어 조작하지 않으므로 어떤 값으로 채워넣어도 상관이 없다.
        /// 여기서 id를 1L로 명시적으로 지정했기 때문에 Select 쿼리로 1L의 Member 데이터가 있는지 쿼리가 수행된다.
        Member member = new Member(1L, "academy", null);
        memberRepository.save(member);

        // Locker를 생성할 때는 Member가 있기 때문에 Member를 설정합니다.
        /// 여기서 id를 1L로 명시적으로 지정했기 때문에 Select 쿼리로 1L의 Locker 데이터가 있는지 쿼리가 수행된다.
        Locker locker = new Locker(1L, "No.1 Locker", member);
        lockerRepository.save(locker);

        // flush()를 호출하여 영속성 컨텍스트를 DB에 반영합니다.
        entityManager.flush();

        // 저장된 Member와 Locker를 조회합니다.
        /// 영속성 컨텍스트를 초기화하지 않았기 때문에 위에서 저장한 Member와 Locker가 그대로 조회됩니다.
        Member foundMember = memberRepository.findById(1L).orElse(null);
        Locker foundLocker = lockerRepository.findById(1L).orElse(null);

        // 양방향 연관관계가 설정되었는지 확인합니다.
        assertThat(foundMember).isNotNull();
        assertThat(foundLocker).isNotNull();
        assertThat(foundLocker.getMember()).isEqualTo(foundMember);

        // TODO #3: 왜 이 테스트가 실패할까요?
        /// 영속성 컨텍스트에 Locker가 null로 저장되어 있던 member로 호출되었기 때문이다.
        /// 통과하려면 영속성 컨텍스트를 비워줘야 한다.
        /// 양방향의 단점 - 일관성을 유지하기 어렵다.
        assertThat(foundMember.getLocker()).isEqualTo(foundLocker);
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
