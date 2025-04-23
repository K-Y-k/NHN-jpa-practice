package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    /// 리스트로 적용한 방식
    List<User> findAllByName(String name);

    /// 페이징으로 적용된 방식 Pageable로 인자를 받아서 가공한 데이터를 Page에 담음
    Page<User> findAllByName(String name, Pageable pageable);
}
