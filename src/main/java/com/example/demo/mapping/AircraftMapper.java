package com.example.demo.mapping;

import org.springframework.stereotype.Component;

import com.example.demo.Requestdto.AircraftRequestdto;
import com.example.demo.Responsedto.AircraftResponsedto;
import com.example.demo.entity.Aircraft;

@Component
public class AircraftMapper {
	public Aircraft toEntity(AircraftRequestdto dto) {
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
	 public AircraftResponsedto toResponse(Aircraft aircraft) {
	        AircraftResponsedto dto = new AircraftResponsedto();
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
