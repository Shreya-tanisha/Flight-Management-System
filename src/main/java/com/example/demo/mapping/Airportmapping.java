package com.example.demo.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Airport;
import com.example.demo.requestdto.Airportrequestdto;
import com.example.demo.responsedto.Airportresponse;
@Component
public class Airportmapping {
	public static Airport toEntity(Airportrequestdto dto) {
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
	 public Airportresponse toResponse(Airport airport) {

	        Airportresponse dto = new Airportresponse();

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
