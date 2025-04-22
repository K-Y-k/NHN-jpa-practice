package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

// TODO #2: `answer` 테이블과 매핑될 `Answer` Entity 클래스를 작성하세요.
/*
 * create table answer
 * (
 *     id          bigint auto_increment
 *         primary key,
 *     question_id bigint   not null,
 *     content     text     not null,
 *     created_at  datetime not null
 * );
 */
/// JPA가 내부적으로 리플렉션을 사용해서 엔티티 객체를 생성하기 때문에 기본 생성자가 필요하다!
/// JPA가 DB에서 데이터를 조회할 때, 엔티티 객체를 만들기 위해 먼저 기본 생성자로 인스턴스를 생성

/// 클래스 내에 생성자가 없으면 기본 생성자가 자동으로 적용된다.
/// 클래스 내에 생성자가 있으면 기본 생성자를 만들어야 한다.

/// 내가 현재 구체적으로 접근해서 사용하는 것이 없으므로 다른 개발자가 이해할 수 있게 PROTECTED 선언
/// 즉, PROTECTED를 선언함으로써 다른 패키지에서 호출이 불가능해짐 (같은 패키지, 상속은 가능)
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {

    /// 실무에서는 박스타입인 Long으로 사용함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long questionId;
    private String content;
    private ZonedDateTime createdAt;

    /// 클래스 내에 생성자가 있으면 기본 생성자를 만들어야 한다.
    public Answer(long id, String content, ZonedDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
    }

}
