package com.ezytek.software.requestdto;

import lombok.Data;

@Data
public class AirportRequestDto {
	 private String code;
	    private String name;
	    private String city;
	    private String country;
	    private String timezone;
	    private Boolean active;
}
