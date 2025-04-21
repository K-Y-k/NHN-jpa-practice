package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.domain.User;
import com.nhnacademy.springbootjpa.error.UserModificationFailureException;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ModifyUserController {

    private final UserRepository userRepository;

    @PutMapping("/users/{id}")
    public User modifyById(@PathVariable("id") String id, @Valid @RequestBody ModifyUserRequest request) {
        User user = userRepository.getById(id);

        /// 나이 추가
        if (!userRepository.modifyById(user.getId(), request.password(), request.age())) {
            throw new UserModificationFailureException();
        }
        return userRepository.getById(id);
    }

}
