package com.ezytek.software.service;

import java.util.List;

import com.ezytek.software.requestdto.AircraftRequestDto;
import com.ezytek.software.responsedto.AircraftResponseDto;

public interface AircraftService {
	AircraftResponseDto save(AircraftRequestDto dto);

    AircraftResponseDto getById(Long id);

    List<AircraftResponseDto> findAllAircraft();

    AircraftResponseDto update(Long id, AircraftRequestDto dto);

    void delete(Long id);

}
