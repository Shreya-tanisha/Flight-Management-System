package com.example.demo.UserResponse;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    Optional<Aircraft> findByRegistrationNumber(String registrationNumber);
}
