package com.ezytek.software.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ezytek.software.repository.AirportRepository;
import com.ezytek.software.entity.Airport;
import com.ezytek.software.exception.ResourceNotFoundException;
import com.ezytek.software.mapping.Airportmapping;
import com.ezytek.software.requestdto.AirportRequestDto;
import com.ezytek.software.responsedto.AirportResponseDto;

@Service
public class Airportserviceimpl implements com.ezytek.software.service.Airportservice {
	private final AirportRepository repo;
	private final Airportmapping mapper;
	


	



	public Airportserviceimpl(AirportRepository repo, Airportmapping mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}



	@Override
	public AirportResponseDto save(AirportRequestDto dto) {
		Airport airport = mapper.toEntity(dto);
		return mapper.toResponse(repo.save(airport));
	}



	@Override
	public AirportResponseDto getById(Long id) {
		 Airport airport = repo.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("Airport not found with id: " + id)
	                );
		return mapper.toResponse(airport);
	}



	@Override
	public List<AirportResponseDto> findAllAirport() {
		
		return repo.findAll().stream().map(mapper::toResponse).toList();
	}



	@Override
	public AirportResponseDto update(Long id, AirportRequestDto dto) {
		
		 Airport airport = repo.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("Airport not found with id: " + id)
	                );
		 BeanUtils.copyProperties(dto, airport,"id","createAt");
		 return mapper.toResponse(repo.save(airport));
	}



	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}



}
