package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

}
