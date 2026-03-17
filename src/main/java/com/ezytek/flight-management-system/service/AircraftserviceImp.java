package com.example.demo.service;

import java.util.List;

import com.example.demo.requestdto.AircraftRequestDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AircraftRepo;
import com.example.demo.responsedto.AircraftResponseDto;
import com.example.demo.entity.Aircraft;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapping.AircraftMapper;
@Service
public class AircraftserviceImp implements com.example.demo.service.Aircraftservice {
	private final AircraftRepo repository;
    private final AircraftMapper mapper;

   
	public AircraftserviceImp(AircraftRepo repository, AircraftMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AircraftResponseDto save(AircraftRequestDto dto) {
		Aircraft aircraft = mapper.toEntity(dto);
		return mapper.toResponse(repository.save(aircraft));
	}

	@Override
	public AircraftResponseDto getById(Long id) {
		Aircraft aircraft=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Aircraft not found with id: " + id)
                );
		return mapper.toResponse(aircraft);
	}

	@Override
	public List<AircraftResponseDto> findAllAircraft() {
		  return repository.findAll()
	                .stream()
	                .map(mapper::toResponse)
	                .toList();
	
	}

	@Override
	public AircraftResponseDto update(Long id, AircraftRequestDto dto) {
		 Aircraft aircraft = repository.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("Aircraft not found with id: " + id)
	                );

	        BeanUtils.copyProperties(dto, aircraft, "id", "createdAt");

	        return mapper.toResponse(repository.save(aircraft));
	}

	@Override
	public void delete(Long id) {
		 repository.deleteById(id);
		
	}

}
