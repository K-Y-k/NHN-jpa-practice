package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @ManyToOne(optional = false)
    private Member member;

    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
