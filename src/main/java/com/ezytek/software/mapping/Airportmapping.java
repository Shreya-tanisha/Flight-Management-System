package com.ezytek.software.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ezytek.software.entity.Airport;
import com.ezytek.software.requestdto.AirportRequestDto;
import com.ezytek.software.responsedto.AirportResponseDto;
@Component
public class Airportmapping {
	public static Airport toEntity(AirportRequestDto dto) {
	Airport airport=new Airport();
	airport.setCode(dto.getCode());
	airport.setName(dto.getName());
    airport.setCity(dto.getCity());
    airport.setCountry(dto.getCountry());
    airport.setTimezone(dto.getTimezone());
    airport.setActive(dto.getActive());
    airport.setCreatedAt(LocalDateTime.now());
	return airport;
	}
	 public AirportResponseDto toResponse(Airport airport) {

	        AirportResponseDto dto = new AirportResponseDto();

	        dto.setId(airport.getId());
	        dto.setCode(airport.getCode());
	        dto.setName(airport.getName());
	        dto.setCity(airport.getCity());
	        dto.setCountry(airport.getCountry());
	        dto.setTimezone(airport.getTimezone());
	        dto.setActive(airport.getActive());
	        dto.setCreatedAt(airport.getCreatedAt());
	        dto.setUpdatedAt(airport.getUpdatedAt());

	        return dto;
	    }

}
