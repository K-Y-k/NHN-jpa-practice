package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Locker {
    @Id
    private long id;

    @Setter
    @NotNull
    private String name;

    /// 소유측, 주인
    @Setter
    @OneToOne
    private Member member;

    /// 양방향 일관성 유지법 : 무한루프가 되지 않으면서 양쪽에 set으로 저장하기
    /// 즉, 이러한 일관성 유지방법이 복잡하다.
    void setMember(Member member) {
        this.member = member;

        // 무한루프 방지
        if (member.getLocker().equals(this)) {
            return;
        }

        // member쪽에 locker 값 설정해주기
        member.setLocker(this);
    }
}
