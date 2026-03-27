package com.ezytek.software.controller;

import com.ezytek.software.requestdto.FlightRequestDto;
import com.ezytek.software.responsedto.FlightResponseDto;
import com.ezytek.software.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping
    public FlightResponseDto save(@RequestBody FlightRequestDto dto) {
        return flightService.save(dto);
    }

    @GetMapping
    public List<FlightResponseDto> getAll() {
        return flightService.findAllFlight();
    }

    @GetMapping("/{id}")
    public FlightResponseDto getById(@PathVariable Long id) {
        return flightService.getById(id);
    }

    @PutMapping("/{id}")
    public FlightResponseDto update(@PathVariable Long id, @RequestBody FlightRequestDto dto) {
        return flightService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        flightService.delete(id);
        return "Flight deleted successfully";
    }
}
