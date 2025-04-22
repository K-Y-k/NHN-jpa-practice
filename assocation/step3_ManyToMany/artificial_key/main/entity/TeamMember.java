package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/// 다 대 다 관계는 중간 테이블을 활용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TeamMember {

    /// 복합 키를 사용하지 않는다.
    /// 복합 키를 사용하면 인덱싱의 성능도 떨어지고 JPA에서의 사용에 복잡도도 올라가 단점이 더 크다.
    /// 인조키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Member member;

    public TeamMember(Team team, Member member) {
        this.team = team;
        this.member = member;
    }

}
