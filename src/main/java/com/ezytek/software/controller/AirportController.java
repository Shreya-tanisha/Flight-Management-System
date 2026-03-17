package com.ezytek.software.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezytek.software.requestdto.AirportRequestDto;
import com.ezytek.software.responsedto.AirportResponseDto;
import com.ezytek.software.service.Airportservice;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
	private final Airportservice service;

    public AirportController(Airportservice service) {
        this.service = service;
    }

    
    @PostMapping
    public ResponseEntity<AirportResponseDto> createAirport(
            @RequestBody AirportRequestDto dto) {

        return ResponseEntity.ok(service.save(dto));
    }

    // Get Airport By Id
    @GetMapping("/{id}")
    public ResponseEntity<AirportResponseDto> getAirportById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }

    // Get All Airports
    @GetMapping
    public ResponseEntity<List<AirportResponseDto>> getAllAirports() {

        return ResponseEntity.ok(service.findAllAirport());
    }

    // Update Airport
    @PutMapping("/{id}")
    public ResponseEntity<AirportResponseDto> updateAirport(
            @PathVariable Long id,
            @RequestBody AirportRequestDto dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    // Delete Airport
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.ok("Airport deleted successfully");
    }
}
