package com.nhnacademy.springbootjpa.controller;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/// 나이 추가
record ModifyUserRequest(@Length(min = 3, max = 20) @NotBlank String password, int age) {
}
