package com.ezytek.software.service;

import java.util.List;

import com.ezytek.software.requestdto.AircraftRequestDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ezytek.software.repository.AircraftRepository;
import com.ezytek.software.responsedto.AircraftResponseDto;
import com.ezytek.software.entity.Aircraft;
import com.ezytek.software.exception.ResourceNotFoundException;
import com.ezytek.software.mapping.AircraftMapper;
@Service
public class AircraftServiceImp implements AircraftService {
	private final AircraftRepository repository;
    private final AircraftMapper mapper;

   
	public AircraftServiceImp(AircraftRepository repository, AircraftMapper mapper) {
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
