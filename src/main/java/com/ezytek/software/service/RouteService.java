package com.ezytek.software.service;

import com.ezytek.software.requestdto.RouteRequestDto;
import com.ezytek.software.responsedto.RouteResponseDto;

import java.util.List;

public interface RouteService {
    RouteResponseDto save(RouteRequestDto dto);

    RouteResponseDto getById(Long id);

    List<RouteResponseDto> findAllRoute();

    RouteResponseDto update(Long id, RouteRequestDto dto);

    void delete(Long id);
}
