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

    @Setter
    @OneToOne
    private Member member;
}
