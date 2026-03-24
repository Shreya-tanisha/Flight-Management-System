package com.ezytek.software.service;

import com.ezytek.software.entity.Airport;
import com.ezytek.software.entity.Route;
import com.ezytek.software.mapping.RouteMapper;
import com.ezytek.software.repository.AirportRepository;
import com.ezytek.software.repository.RouteRepository;
import com.ezytek.software.requestdto.RouteRequestDto;
import com.ezytek.software.responsedto.RouteResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceimpl implements RouteService{
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private RouteMapper rm;

    @Override
    public RouteResponseDto save(RouteRequestDto dto) {

        Airport source = airportRepository.findById(dto.getSourceAirportId())
                .orElseThrow(() -> new RuntimeException("Source airport not found"));

        Airport destination = airportRepository.findById(dto.getDestinationAirportId())
                .orElseThrow(() -> new RuntimeException("Destination airport not found"));

        Route route = rm.toEntity(dto, source, destination);

        return rm.toResponse(routeRepository.save(route));
    }

    @Override
    public RouteResponseDto getById(Long id) {
        Route route=routeRepository.findById(id).orElseThrow(()->new RuntimeException("Route not found"));
        return rm.toResponse(route);
    }

    @Override
    public List<RouteResponseDto> findAllRoute() {
        return routeRepository.findAll()
                .stream()
                .map(rm::toResponse)
                .toList();
    }

    @Override
    public RouteResponseDto update(Long id, RouteRequestDto dto) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));

        Airport source = airportRepository.findById(dto.getSourceAirportId())
                .orElseThrow(() -> new RuntimeException("Source airport not found"));

        Airport destination = airportRepository.findById(dto.getDestinationAirportId())
                .orElseThrow(() -> new RuntimeException("Destination airport not found"));


        BeanUtils.copyProperties(dto, route, "id", "sourceAirport", "destinationAirport", "createdAt");

        route.setSourceAirport(source);
        route.setDestinationAirport(destination);

        return rm.toResponse(routeRepository.save(route));
    }

    @Override
    public void delete(Long id) {
        Route route=routeRepository.findById(id).orElseThrow(()->new RuntimeException("Route not found"));
        routeRepository.delete(route);
    }
}
