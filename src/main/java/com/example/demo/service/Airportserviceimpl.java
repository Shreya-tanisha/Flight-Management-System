package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AirportRepository;
import com.example.demo.entity.Airport;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapping.Airportmapping;
import com.example.demo.requestdto.Airportrequestdto;
import com.example.demo.responsedto.Airportresponse;

@Service
public class Airportserviceimpl implements Airportservice{
	private final AirportRepository repo;
	private final Airportmapping mapper;
	


	



	public Airportserviceimpl(AirportRepository repo, Airportmapping mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}



	@Override
	public Airportresponse save(Airportrequestdto dto) {
		Airport airport = mapper.toEntity(dto);
		return mapper.toResponse(repo.save(airport));
	}



	@Override
	public Airportresponse getById(Long id) {
		 Airport airport = repo.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("Airport not found with id: " + id)
	                );
		return mapper.toResponse(airport);
	}



	@Override
	public List<Airportresponse> findAllAirport() {
		
		return repo.findAll().stream().map(mapper::toResponse).toList();
	}



	@Override
	public Airportresponse update(Long id, Airportrequestdto dto) {
		
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
