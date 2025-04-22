package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// TODO #1: `Member` Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    private long id;

    @Setter
    @NotNull
    private String name;

    /// 1 대 1 관계에서는 주인을 아무나 설정 가능
    /// 연관 객체를 자주 꺼내올 것 같은 곳에 주인으로 설정하자
    /// 주인이지만 결국 이 연관 객체를 관리하기 위해 따라다니는 입장으로 약자쪽이다.
    @Setter
    @OneToOne
    // @JoinColumn(name = "repositoryId") id 명칭을 지정하고 싶은 경우 사용
    private Locker locker;
}
