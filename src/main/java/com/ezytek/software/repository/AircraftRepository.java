package com.ezytek.software.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezytek.software.entity.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
	Optional<Aircraft> findByRegistrationNumber(String registrationNumber);
}
