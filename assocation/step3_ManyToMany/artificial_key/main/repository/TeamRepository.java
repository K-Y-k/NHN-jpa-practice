package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
