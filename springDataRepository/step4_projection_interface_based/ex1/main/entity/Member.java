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

    // TODO #1: 영속성 전이 설정
    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
