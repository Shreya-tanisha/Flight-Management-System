package com.ezytek.software.mapping;


import org.springframework.stereotype.Component;

import com.ezytek.software.requestdto.AircraftRequestDto;
import com.ezytek.software.responsedto.AircraftResponseDto;
import com.ezytek.software.entity.Aircraft;

@Component
public class AircraftMapper {
	public Aircraft toEntity(AircraftRequestDto dto) {
        Aircraft aircraft = new Aircraft();
        aircraft.setModel(dto.getModel());
        aircraft.setManufacturer(dto.getManufacturer());
        aircraft.setRegistrationNumber(dto.getRegistrationNumber());
        aircraft.setTotalSeats(dto.getTotalSeats());
        aircraft.setEconomySeats(dto.getEconomySeats());
        aircraft.setBusinessSeats(dto.getBusinessSeats());
        aircraft.setActive(dto.getActive());
        return aircraft;
    }

	public AircraftResponseDto toResponse(Aircraft aircraft) {
	        AircraftResponseDto dto = new AircraftResponseDto();
	        dto.setId(aircraft.getId());
	        dto.setModel(aircraft.getModel());
	        dto.setManufacturer(aircraft.getManufacturer());
	        dto.setRegistrationNumber(aircraft.getRegistrationNumber());
	        dto.setTotalSeats(aircraft.getTotalSeats());
	        dto.setEconomySeats(aircraft.getEconomySeats());
	        dto.setBusinessSeats(aircraft.getBusinessSeats());
	        dto.setActive(aircraft.getActive());
	        dto.setCreatedAt(aircraft.getCreatedAt());
	        return dto;
	    }

}
