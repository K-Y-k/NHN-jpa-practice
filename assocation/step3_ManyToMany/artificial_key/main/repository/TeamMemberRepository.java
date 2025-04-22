package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
