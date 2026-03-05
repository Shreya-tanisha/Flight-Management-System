package com.example.demo.Responsedto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AircraftResponsedto {
	 private Long id;
	    private String model;
	    private String manufacturer;
	    private String registrationNumber;
	    private Integer totalSeats;
	    private Integer economySeats;
	    private Integer businessSeats;
	    private Boolean active;
	    private LocalDateTime createdAt;

}
