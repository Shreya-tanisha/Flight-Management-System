package com.ezytek.software.service;

import com.ezytek.software.requestdto.FlightRequestDto;
import com.ezytek.software.responsedto.FlightResponseDto;

import java.util.List;

public interface FlightService {
    FlightResponseDto save(FlightRequestDto dto);

    FlightResponseDto getById(Long id);

    List<FlightResponseDto> findAllFlight();

    FlightResponseDto update(Long id, FlightRequestDto dto);

    void delete(Long id);
}
