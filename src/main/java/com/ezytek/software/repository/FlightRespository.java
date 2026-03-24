package com.ezytek.software.repository;

import com.ezytek.software.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FlightRespository  extends JpaRepository <Flight,Long>{
}
