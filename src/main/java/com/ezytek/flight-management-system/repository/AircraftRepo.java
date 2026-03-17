package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Aircraft;

public interface AircraftRepo extends JpaRepository<Aircraft, Long> {
	Optional<Aircraft> findByRegistrationNumber(String registrationNumber);
}
