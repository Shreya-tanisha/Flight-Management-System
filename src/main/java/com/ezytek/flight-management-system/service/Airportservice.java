package com.example.demo.service;

import java.util.List;



import com.example.demo.requestdto.Airportrequestdto;
import com.example.demo.responsedto.Airportresponse;


public interface Airportservice {
	Airportresponse save(Airportrequestdto dto);

    Airportresponse getById(Long id);

    List<Airportresponse> findAllAirport();

    Airportresponse update(Long id, Airportrequestdto dto);

    void delete(Long id);

}
