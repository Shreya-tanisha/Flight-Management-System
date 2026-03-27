package com.ezytek.software.service;

import com.ezytek.software.requestdto.AirportRequestDto;
import com.ezytek.software.requestdto.BookingRequestDto;
import com.ezytek.software.responsedto.AirportResponseDto;
import com.ezytek.software.responsedto.BookingResponseDto;

import java.util.List;

public interface BookingService {
    BookingResponseDto save(BookingRequestDto dto);

    BookingResponseDto getById(Long id);

    List<BookingResponseDto> findAllAirport();

    void cancelBooking(Long id);
}
