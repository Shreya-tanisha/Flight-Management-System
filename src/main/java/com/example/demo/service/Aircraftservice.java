package com.example.demo.service;

import java.util.List;

import com.example.demo.Requestdto.AircraftRequestdto;
import com.example.demo.Responsedto.AircraftResponsedto;

public interface Aircraftservice {
	AircraftResponsedto save(AircraftRequestdto dto);

    AircraftResponsedto getById(Long id);

    List<AircraftResponsedto> findAllAircraft();

    AircraftResponsedto update(Long id, AircraftRequestdto dto);

    void delete(Long id);

}
