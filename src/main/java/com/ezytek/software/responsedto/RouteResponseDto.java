package com.ezytek.software.responsedto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RouteResponseDto {
    private Long id;
    private String sourceAirportName;
    private String destinationAirportName;
    private Integer distanceKm;
    private Integer estimatedDurationMinutes;
    private Boolean active;
    private LocalDateTime createdAt;
}
