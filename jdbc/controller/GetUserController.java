package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.domain.User;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetUserController {

    private final UserRepository userRepository;

    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") String id) {
        return userRepository.getById(id);
    }

}
