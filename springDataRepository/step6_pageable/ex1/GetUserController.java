package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import com.nhnacademy.springbootjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // TODO: `GET /users?page=1&size=5` 와 같은 요청을 처리할 수 있도록 구현

    /// web support의 PageableHandlerMethodArgumentResolver가 MVC request parameter를 Pageable 인스턴스로 변환할 수 있도록 해준다.
    /// SortHandlerMethodArgumentResolver가 MVC request parameter를 Sort 인스턴스로 변환할 수 있도록 해준다.

    /// 주의점
    ///
    /// @PageableDefault 없을 때는 size의 기본 값이 20인데
    /// @PageableDefault이 있을 때의 size의 기본 값이 10이다.
    /// sort 속성의 기본 값은 오름차순
    @GetMapping("/users")
    public Page<User> findAll(@PageableDefault(size = 7, sort = {"name", "age"}, direction = Sort.Direction.DESC) Pageable pageable, Sort sort) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

}
