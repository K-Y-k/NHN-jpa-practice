package com.nhnacademy.springbootjpa.service;

import com.nhnacademy.springbootjpa.entity.User;

public interface UserService {
    User getById(String id);

    User create(String id, String password);

    User modifyById(String id, String password);
}
