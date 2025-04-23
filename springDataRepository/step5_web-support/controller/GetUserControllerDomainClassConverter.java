package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.error.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    // TODO #1: DomainClassConverter를 이용해서 path variable로 Entity를 받음

    /// @PathVariable에서 바로 id 값을 통해 해당 User로 받아와짐
    /// DomainClassConverter의 기능으로 변환 과정을 압축해서 자동으로 적용

    /// 보통은 규칙의 일관성을 유지하기 위해
    /// Request dto를 받아서 관련 비즈니스 로직을 수행 후 Response dto로 가공하는 과정의 층을 분리 시키는 것을 권장하기에 잘 쓰지 않음
    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") Optional<User> optionalUser) {
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
