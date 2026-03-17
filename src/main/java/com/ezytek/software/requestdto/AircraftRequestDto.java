package com.ezytek.software.requestdto;

import lombok.Data;

@Data
public class AircraftRequestDto {
	 private String model;
	    private String manufacturer;
	    private String registrationNumber;
	    private Integer totalSeats;
	    private Integer economySeats;
	    private Integer businessSeats;
	    private Boolean active;

}
