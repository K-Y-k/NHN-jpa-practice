package com.nhnacademy.subjectweek04.user.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.nhnacademy.subjectweek04.user.entity.Auth;
import com.nhnacademy.subjectweek04.user.entity.QUsers;
import com.nhnacademy.subjectweek04.user.entity.Users;
import com.nhnacademy.subjectweek04.user.repository.UserQueryDslRepository;

/// QueryDsl 적용
public class UserQueryDslRepositoryImpl extends QuerydslRepositorySupport implements UserQueryDslRepository {
	public UserQueryDslRepositoryImpl() {
		super(Users.class);
	}

	/// 주어진 역할에 따른 유저 조회
	@Override
	public List<Users> findAllByAuth(Auth auth) {
		QUsers users = QUsers.users;

		return from(users)
			.where(users.userAuth.eq(auth))
			.select(users)
			.distinct()
			.fetch();
	}
}
