package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// TODO #3: `enrollment` 테이블과 매핑될 `Enrollment` Entity 클래스
//           Entity 매핑과 연관관계 매핑을 하세요.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Enrollment {
    @Id
    private long id;

    @ManyToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false)
    private Course course;

    private LocalDateTime enrolledAt;

}
