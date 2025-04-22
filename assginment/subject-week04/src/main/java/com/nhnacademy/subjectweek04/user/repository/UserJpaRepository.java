package com.nhnacademy.subjectweek04.user.repository;

import com.nhnacademy.subjectweek04.user.entity.Auth;
import com.nhnacademy.subjectweek04.user.entity.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(String userId);
    Optional<Users> findByUserIdAndUserPassword(String userId, String userPassword);

    // List<Users> findAll();
    List<Users> findAllByUserAuth(Auth userAuth);

    // Users save(Users users);
    void deleteByUserId(String userId);

    long count();
    long countByUserId(String userId);

    Page<Users> findAllByUserAuth(Auth userAuth, Pageable pageable);
}
