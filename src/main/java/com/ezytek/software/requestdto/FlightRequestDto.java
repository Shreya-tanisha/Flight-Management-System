package com.ezytek.software.requestdto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightRequestDto {

        private String flightNumber;
        private Long routeId;
        private Long aircraftId;

        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;

        private String status;

        private Integer availableSeats;
        private BigDecimal price;
        private String gateNumber;
    }

