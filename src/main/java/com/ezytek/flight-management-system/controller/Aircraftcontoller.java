package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.requestdto.AircraftRequestDto;
import com.example.demo.responsedto.AircraftResponseDto;
import com.example.demo.service.Aircraftservice;

@RestController
@RequestMapping("/aircraft")
public class Aircraftcontoller {
	 @Autowired
	    private Aircraftservice aircraftService;

	    
	    @PostMapping
	    public AircraftResponseDto saveAircraft(@RequestBody AircraftRequestDto dto) {
	        return aircraftService.save(dto);
	    }

	    
	    @GetMapping("/{id}")
	    public AircraftResponseDto getAircraftById(@PathVariable Long id) {
	        return aircraftService.getById(id);
	    }

	    
	    @GetMapping
	    public List<AircraftResponseDto> getAllAircraft() {
	        return aircraftService.findAllAircraft();
	    }

	   
	    @PutMapping("/{id}")
	    public AircraftResponseDto updateAircraft(@PathVariable Long id,
	                                              @RequestBody AircraftRequestDto dto) {
	        return aircraftService.update(id, dto);
	    }

	    
	    @DeleteMapping("/{id}")
	    public String deleteAircraft(@PathVariable Long id) {
	        aircraftService.delete(id);
	        return "Aircraft deleted successfully";
	    }

}
