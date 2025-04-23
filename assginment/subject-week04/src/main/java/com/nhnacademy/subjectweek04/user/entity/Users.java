package com.nhnacademy.subjectweek04.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.subjectweek04.point.entity.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Users {

	@Id
	@Column(nullable = false, length = 50)
	private String userId;

	@Column(nullable = false, length = 50)
	private String userName;

	@Column(nullable = false, length = 200)
	private String userPassword;

	@Column(nullable = false, length = 10)
	private String userBirth;

	@Column(nullable = false, length = 10)
	private Auth userAuth;

	@Column(nullable = false)
	private int userPoint;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime latestLoginAt;

	/// lazy loading 이 @Transactional 밖에서 예외 떨어지는 상황으로 인해 eager loading으로 설정
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Point> pointList;

}
