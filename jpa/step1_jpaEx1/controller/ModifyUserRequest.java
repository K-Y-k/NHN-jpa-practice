package com.nhnacademy.springbootjpa.controller;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

record ModifyUserRequest(@Length(min = 3, max = 20) @NotBlank String password) {
}
