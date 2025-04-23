package com.nhnacademy.subjectweek04.address.entity;

import java.time.LocalDateTime;

import com.nhnacademy.subjectweek04.user.entity.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long addressId;

	@ManyToOne(optional = false)
	private Users user;

	@Column(nullable = false, length = 255)
	private String addressName;

	@Column(nullable = false)
	private LocalDateTime createdAt;

}
