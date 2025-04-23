package com.nhnacademy.subjectweek04.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhnacademy.subjectweek04.user.entity.Auth;
import com.nhnacademy.subjectweek04.user.entity.UserNameOnlyView;
import com.nhnacademy.subjectweek04.user.entity.Users;

public interface UserJpaRepository extends JpaRepository<Users, String>, UserQueryDslRepository {
	Optional<Users> findByUserId(String userId);

	Optional<Users> findByUserIdAndUserPassword(String userId, String userPassword);

	// List<Users> findAll();

	/// 닫힌 프로젝션 사용
	UserNameOnlyView queryUsersByUserId(String userId);

	/// JPQL 사용
	@Query("select u from Users u where u.userAuth = :auth and u.userPoint >= :userPoint")
	List<Users> findByAuthAndPointGreaterThan(Auth auth, int userPoint);

	// Users save(Users users);
	void deleteByUserId(String userId);

	long countByUserId(String userId);

	Page<Users> findAllByUserAuth(Auth userAuth, Pageable pageable);
}
