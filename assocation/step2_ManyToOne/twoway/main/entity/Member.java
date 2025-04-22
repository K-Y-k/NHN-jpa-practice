package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    // TODO #1: 일대다 연관 관계 설정(mappedBy를 사용하여 주인이 아님을 설정)
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    // TODO #2: 영속성 전이 설정 예시
    // 자동으로 적용하면 위험성이 있으므로 잘 알고 사용하는 것이 아니면 사용을 권하지 않는다.
    // @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    // private List<Post> posts = new ArrayList<>();


    public Member(String name) {
        this.name = name;
    }
}
