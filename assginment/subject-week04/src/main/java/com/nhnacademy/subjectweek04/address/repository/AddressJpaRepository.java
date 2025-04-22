package com.nhnacademy.subjectweek04.address.repository;

import com.nhnacademy.subjectweek04.address.entity.Address;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {
    // 없어도 제공되는 기본 메소드
    // Address save(Address address);
    Address deleteByAddressId(long addressId);
    Optional<Address> findByAddressId(long addressId);
    List<Address> findAllByUser_UserId(String userId);
}
