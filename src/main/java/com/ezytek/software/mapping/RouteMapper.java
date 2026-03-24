package com.ezytek.software.mapping;

import com.ezytek.software.entity.Airport;
import com.ezytek.software.entity.Route;
import com.ezytek.software.requestdto.RouteRequestDto;
import com.ezytek.software.responsedto.RouteResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class RouteMapper {
    public Route toEntity(RouteRequestDto dto, Airport source, Airport destination) {
      Route route =new Route();
        BeanUtils.copyProperties(dto,route);
        route.setSourceAirport(source);
        route.setDestinationAirport(destination);

        route.setCreatedAt(LocalDateTime.now());
        return route;

    }
    public RouteResponseDto toResponse(Route route){
        RouteResponseDto dto=new RouteResponseDto();
        BeanUtils.copyProperties(route,dto);
        dto.setSourceAirportName(route.getSourceAirport().getName());
        dto.setDestinationAirportName(route.getDestinationAirport().getName());

        return dto;
    }
}
