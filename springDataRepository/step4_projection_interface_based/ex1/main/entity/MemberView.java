package com.nhnacademy.springbootjpa.entity;

import java.util.List;

// TODO #7: 중첩 구조를 갖는 Member 프로젝션 인터페이스
public interface MemberView {
    String getId();

    String getName();

    List<PostView> getPosts();

    interface PostView {
        long getId();

        String getTitle();

        String getContent();
    }
}
