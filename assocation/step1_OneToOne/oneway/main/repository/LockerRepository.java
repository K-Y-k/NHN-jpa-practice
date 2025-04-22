package com.nhnacademy.springbootjpa.repository;

import com.nhnacademy.springbootjpa.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {
}
