package com.ezytek.software.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
     @Data
    @Entity
    @Table(name = "routes")
    public class Route {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Integer distanceKm;
        private Integer estimatedDurationMinutes;
        private Boolean active;

        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name ="source_airport_id")
        private Airport sourceAirport;

        @ManyToOne
        @JoinColumn(name = "destination_airport_id")
        private Airport destinationAirport;
    }

