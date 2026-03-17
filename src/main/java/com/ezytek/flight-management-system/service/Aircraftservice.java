package com.example.demo.service;

import java.util.List;

import com.example.demo.requestdto.AircraftRequestDto;
import com.example.demo.responsedto.AircraftResponseDto;

public interface Aircraftservice {
	AircraftResponseDto save(AircraftRequestDto dto);

    AircraftResponseDto getById(Long id);

    List<AircraftResponseDto> findAllAircraft();

    AircraftResponseDto update(Long id, AircraftRequestDto dto);

    void delete(Long id);

}
