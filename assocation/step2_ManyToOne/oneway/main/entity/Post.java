package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO #1: `Post` Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    /// optional = true는 해당 연관 객체가 없어도 생성이 가능하다로 설정한다.(기본 값)
    /// 즉, 연관 객체는 null이 올 수 있음
    /// false이면 연관 객체가 필수로 들어와야 할 때 설정
    @ManyToOne(optional = false)
    private Member member;

    /// 만약 post에 cascade = CascadeType.PERSIST를 부여하면
    /// member를 save하지 않았었도 post에 해당 member 객체를 넣고 저장하면 member도 같이 먼저 저장된다.
    // @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    // private Member member;


    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
