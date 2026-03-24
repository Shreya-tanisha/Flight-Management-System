package com.ezytek.software.mapping;

import com.ezytek.software.entity.Aircraft;
import com.ezytek.software.entity.Flight;
import com.ezytek.software.entity.Route;
import com.ezytek.software.enums.FlightStatus;
import com.ezytek.software.requestdto.FlightRequestDto;
import com.ezytek.software.responsedto.FlightResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public Flight toEntity(FlightRequestDto dto, Route route, Aircraft aircraft){
        Flight flight = new Flight();

        BeanUtils.copyProperties(dto, flight);

        flight.setRoute(route);
        flight.setAircraft(aircraft);

        flight.setStatus(FlightStatus.valueOf(dto.getStatus()));

        return flight;
    }
    public FlightResponseDto toResponse(Flight flight){
        FlightResponseDto dto = new FlightResponseDto();

        BeanUtils.copyProperties(flight, dto);
        dto.setRouteInfo(
                flight.getRoute().getSourceAirport().getName() + " → " +
                        flight.getRoute().getDestinationAirport().getName()
        );

        dto.setAircraftModel(flight.getAircraft().getModel());

        dto.setStatus(flight.getStatus().name());

        return dto;

    }



}
