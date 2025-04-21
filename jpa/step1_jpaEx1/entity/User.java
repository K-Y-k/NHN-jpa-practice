package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
    /// DTO에서 유효성 체크를 하지만
    /// 엔티티에도 유효성 체크를 한번 더 체크하여 안전성 향상 
    @Length(min = 3, max = 50)
    @Id
    private String id;

    @Length(min = 3, max = 20)
    @NotNull
    @Setter
    private String password;
}
