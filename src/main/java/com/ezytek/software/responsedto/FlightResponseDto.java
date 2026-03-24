package com.ezytek.software.responsedto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class FlightResponseDto {
    private Long id;
    private String flightNumber;

    private String routeInfo;
    private String aircraftModel;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private String status;

    private Integer availableSeats;
    private BigDecimal price;
    private String gateNumber;

    private LocalDateTime createdAt;
}
