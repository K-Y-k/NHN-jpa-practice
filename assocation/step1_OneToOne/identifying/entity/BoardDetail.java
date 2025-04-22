package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO #2: `BoardDetail` Entity 생성
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BoardDetail {
    /**
     *  Id가 겹칠 경우
     *  Id를 반드시 선언해야 해서 Board의 boardId를 중복으로 선언해주게 되는데
     *  이러면 Board의 boardId와 서로 충돌이 일어난다.
     */
    @Id
    private long boardId;

    /// 그래서 @MapsId를 선언하면 충돌을 방지해줄 수 있다.
    @MapsId
    @OneToOne
    private Board board;

    private String content;

    public BoardDetail(Board board, String content) {
        this.board = board;
        this.content = content;
    }
}
