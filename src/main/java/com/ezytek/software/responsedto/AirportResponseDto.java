package com.ezytek.software.responsedto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AirportResponseDto {
	 private Long id;
	    private String code;
	    private String name;
	    private String city;
	    private String country;
	    private String timezone;
	    private Boolean active;
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;
}
