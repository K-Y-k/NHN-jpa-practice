package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.domain.User;
import com.nhnacademy.springbootjpa.error.UserCreationFailureException;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CreateUserController {

    private final UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users")
    public User create(@Valid @RequestBody CreateUserRequest request) {
        /// 나이 추가
        if (!userRepository.create(request.id(), request.password(), request.age())) {
            throw new UserCreationFailureException();
        }

        return userRepository.getById(request.id());
    }

}
