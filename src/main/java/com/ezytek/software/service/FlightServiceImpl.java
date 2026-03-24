package com.ezytek.software.service;

import com.ezytek.software.entity.Aircraft;
import com.ezytek.software.entity.Flight;
import com.ezytek.software.entity.Route;
import com.ezytek.software.enums.FlightStatus;
import com.ezytek.software.mapping.FlightMapper;
import com.ezytek.software.repository.AircraftRepository;
import com.ezytek.software.repository.FlightRespository;
import com.ezytek.software.repository.RouteRepository;
import com.ezytek.software.requestdto.FlightRequestDto;
import com.ezytek.software.responsedto.FlightResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    public RouteRepository route;
    @Autowired
    public AircraftRepository aircraft;
    @Autowired
    public FlightRespository flightrepo;
    @Autowired
    public FlightMapper flightmapper;
    @Override
    public FlightResponseDto save(FlightRequestDto dto) {
       Route rou= route.findById(dto.getRouteId()).orElseThrow(()->new RuntimeException("Route not found"));
       Aircraft air=aircraft.findById(dto.getAircraftId()).orElseThrow(()->new RuntimeException("Aircraft not found"));
        Flight flight=flightmapper.toEntity(dto,rou,air);
        return flightmapper.toResponse(flightrepo.save(flight));
    }

    @Override
    public FlightResponseDto getById(Long id) {
        Flight flight=flightrepo.findById(id).orElseThrow(()-> new RuntimeException("Flight not found"));
        return flightmapper.toResponse(flight);
    }

    @Override
    public List<FlightResponseDto> findAllFlight() {
        return flightrepo.findAll().stream().map(flightmapper::toResponse).toList();
    }

    @Override
    public FlightResponseDto update(Long id, FlightRequestDto dto) {
        Flight flight=flightrepo.findById(id).orElseThrow(()-> new RuntimeException("Flight not found"));
        Route rou= route.findById(dto.getRouteId()).orElseThrow(()->new RuntimeException("Route not found"));
        Aircraft air=aircraft.findById(dto.getAircraftId()).orElseThrow(()->new RuntimeException("Aircraft not found"));
        BeanUtils.copyProperties(dto,flight,"id","creadAt");
        flight.setRoute(rou);
        flight.setAircraft(air);
        flight.setStatus(FlightStatus.valueOf(dto.getStatus()));
        return flightmapper.toResponse(flightrepo.save(flight));
    }

    @Override
    public void delete(Long id) {
        flightrepo.deleteById(id);
    }
}
