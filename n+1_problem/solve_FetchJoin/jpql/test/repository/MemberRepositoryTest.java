package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Locker;
import com.nhnacademy.springbootjpa.entity.Member;
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

    // TODO #2: 아래 테스트 결과에서 호출하는 쿼리를 확인하세요.
    @Sql("member-repository-test.sql")
    @Test
    void findAllTest() {
        List<String> lockerNames = memberRepository.findAllWithAssociation()
                .stream()
                .map(Member::getLocker)
                .map(Locker::getName)
                .toList();

        assertThat(lockerNames).hasSize(10);
    }

}
