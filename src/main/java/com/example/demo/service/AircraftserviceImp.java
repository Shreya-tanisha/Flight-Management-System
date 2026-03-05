package com.example.demo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AircraftRepo;
import com.example.demo.Requestdto.AircraftRequestdto;
import com.example.demo.Responsedto.AircraftResponsedto;
import com.example.demo.entity.Aircraft;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapping.AircraftMapper;
@Service
public class AircraftserviceImp implements Aircraftservice {
	private final AircraftRepo repository;
    private final AircraftMapper mapper;

   
	public AircraftserviceImp(AircraftRepo repository, AircraftMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AircraftResponsedto save(AircraftRequestdto dto) {
		Aircraft aircraft = mapper.toEntity(dto);
		return mapper.toResponse(repository.save(aircraft));
	}

	@Override
	public AircraftResponsedto getById(Long id) {
		Aircraft aircraft=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Aircraft not found with id: " + id)
                );
		return mapper.toResponse(aircraft);
	}

	@Override
	public List<AircraftResponsedto> findAllAircraft() {
		  return repository.findAll()
	                .stream()
	                .map(mapper::toResponse)
	                .toList();
	
	}

	@Override
	public AircraftResponsedto update(Long id, AircraftRequestdto dto) {
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
