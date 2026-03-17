package com.ezytek.software.service;

import java.util.List;



import com.ezytek.software.requestdto.AirportRequestDto;
import com.ezytek.software.responsedto.AirportResponseDto;


public interface Airportservice {
	AirportResponseDto save(AirportRequestDto dto);

    AirportResponseDto getById(Long id);

    List<AirportResponseDto> findAllAirport();

    AirportResponseDto update(Long id, AirportRequestDto dto);

    void delete(Long id);

}
