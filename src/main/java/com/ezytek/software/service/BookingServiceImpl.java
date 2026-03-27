package com.ezytek.software.service;

import com.ezytek.software.UserResponse.UserRepository;
import com.ezytek.software.entity.Booking;
import com.ezytek.software.entity.Flight;
import com.ezytek.software.entity.User;
import com.ezytek.software.enums.BookingStatus;
import com.ezytek.software.mapping.BookingMapper;
import com.ezytek.software.repository.BookingRepository;
import com.ezytek.software.repository.FlightRespository;
import com.ezytek.software.requestdto.BookingRequestDto;
import com.ezytek.software.responsedto.BookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingServiceImpl implements BookingService{
    @Autowired
    FlightRespository  flightRespository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookingMapper bookingmapper;
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public BookingResponseDto save(BookingRequestDto dto) {
        Flight flight=flightRespository.findById(dto.getFlightId()).orElseThrow(()-> new RuntimeException("Flight doesn.t exists"));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Booking booking=bookingmapper.toEntity(dto,flight,user);
        return bookingmapper.toResponse(bookingRepository.save(booking));
    }

    @Override
    public BookingResponseDto getById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return bookingmapper.toResponse(booking);
    }

    @Override
    public List<BookingResponseDto> findAllAirport() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingmapper::toResponse)
                .toList();
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setBookingStatus(BookingStatus.CANCELLED);

        bookingRepository.save(booking);

    }
}
