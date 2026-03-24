package com.ezytek.software.requestdto;

import lombok.Data;

@Data
public class RouteRequestDto {

    private Long sourceAirportId;
    private Long destinationAirportId;
    private Integer distanceKm;
    private Integer estimatedDurationMinutes;
    private Boolean active;
}
