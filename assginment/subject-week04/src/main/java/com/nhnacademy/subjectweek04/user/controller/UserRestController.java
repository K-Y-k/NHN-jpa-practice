package com.nhnacademy.subjectweek04.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhnacademy.subjectweek04.user.entity.Auth;
import com.nhnacademy.subjectweek04.user.entity.UserNameOnlyView;
import com.nhnacademy.subjectweek04.user.entity.Users;
import com.nhnacademy.subjectweek04.user.repository.UserJpaRepository;

import jakarta.transaction.Transactional;

@Transactional
@RestController
public class UserRestController {

	private final UserJpaRepository userRepository;

	public UserRestController(UserJpaRepository userJpaRepository) {
		this.userRepository = userJpaRepository;
	}

	/// Projection 적용
	@GetMapping("/user")
	public UserNameOnlyView getUser(@RequestParam String userId) {
		return userRepository.queryUsersByUserId(userId);
	}

	/// DomainClassConverter 적용
	@GetMapping("/user/{userId}")
	public Users getUser(@PathVariable("userId") Optional<Users> user) {
		return user.orElseThrow(() -> new RuntimeException("user not found"));
	}

	/// Pageable 을 이용한 pagination 적용
	@GetMapping("/user/page")
	public Page<Users> getPageUsersByAuth(@RequestParam Auth auth, Pageable pageable) {
		return userRepository.findAllByUserAuth(auth, pageable);
	}

	/// QueryDsl 사용
	@GetMapping("/user/list")
	public List<Users> getListUsersByAuth(@RequestParam Auth auth) {
		return userRepository.findAllByAuth(auth);
	}

	/// JPQL 사용
	@RequestMapping(method = RequestMethod.GET, value = "/user/list", params = {"auth", "userPoint"})
	public List<Users> getUserByAuthAndPointGreaterThan(@RequestParam Auth auth, @RequestParam int userPoint) {
		return userRepository.findByAuthAndPointGreaterThan(auth, userPoint);
	}

	@PostMapping("/user")
	public Users saveUser(@RequestBody Users user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable("userId") Optional<Users> user) {
		userRepository.delete(user.orElseThrow(() -> new RuntimeException("user not found")));
	}

}
