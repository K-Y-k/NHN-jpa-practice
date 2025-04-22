package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Member;
import com.nhnacademy.springbootjpa.entity.Team;
import com.nhnacademy.springbootjpa.entity.TeamMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ManyToManyTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {
        // member1 생성 후 저장
        Member member1 = new Member(1L, "member1");
        Member savedMember1 = memberRepository.save(member1);

        // member2 생성 후 저장
        Member member2 = new Member(2L, "member2");
        Member savedMember2 = memberRepository.save(member2);

        // team1 생성 후 저장
        Team team1 = new Team(1L, "team1");
        Team savedTeam1 = teamRepository.save(team1);

        // team2 생성 후 저장
        Team team2 = new Team(2L, "team2");
        Team savedTeam2 = teamRepository.save(team2);

        // team1에 member1 추가
        teamMemberRepository.save(
                new TeamMember(
                        savedTeam1,
                        savedMember1
                )
        );

        // team1에 member1 추가
        teamMemberRepository.save(
                new TeamMember(
                        savedTeam1,
                        savedMember2
                )
        );

        // team2에 member1 추가
        teamMemberRepository.save(
                new TeamMember(
                        savedTeam2,
                        savedMember1
                )
        );

        // entityManager.flush()를 호출하여 영속성 컨텍스트의 변경사항을 데이터베이스에 반영
        entityManager.flush();
    }

}
