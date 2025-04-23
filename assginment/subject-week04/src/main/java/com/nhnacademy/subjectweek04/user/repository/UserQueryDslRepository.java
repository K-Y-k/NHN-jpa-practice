package com.nhnacademy.subjectweek04.user.repository;

import java.util.List;

import com.nhnacademy.subjectweek04.user.entity.Auth;
import com.nhnacademy.subjectweek04.user.entity.Users;

public interface UserQueryDslRepository {

	/// 주어진 역할에 따른 유저 조회
	List<Users> findAllByAuth(Auth auth);
}
