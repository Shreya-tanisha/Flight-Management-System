package com.example.demo.Requestdto;

import lombok.Data;

@Data
public class AircraftRequestdto {
	 private String model;
	    private String manufacturer;
	    private String registrationNumber;
	    private Integer totalSeats;
	    private Integer economySeats;
	    private Integer businessSeats;
	    private Boolean active;

}
