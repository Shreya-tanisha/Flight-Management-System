package com.ezytek.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezytek.software.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
