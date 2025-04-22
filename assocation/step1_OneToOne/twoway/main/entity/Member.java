package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// TODO #1: `Member` Entity에 양방향 연관 관계 설정
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

    /// 비소유측이라 mappedBy 적용
    @Setter
    @OneToOne(mappedBy = "member")
    private Locker locker;

    void setLocker(Locker locker) {
        this.locker = locker;

        if (locker.getMember().equals(this)) {
            return;
        }

        locker.setMember(this);
    }
}
