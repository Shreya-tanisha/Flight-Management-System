package com.ezytek.software.controller;

import com.ezytek.software.requestdto.BookingRequestDto;
import com.ezytek.software.responsedto.BookingResponseDto;
import com.ezytek.software.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // ✅ Create Booking
    @PostMapping("/save")
    public BookingResponseDto save(@RequestBody BookingRequestDto dto) {
        return bookingService.save(dto);
    }

    // ✅ Get Booking by ID
    @GetMapping("/{id}")
    public BookingResponseDto getById(@PathVariable Long id) {
        return bookingService.getById(id);
    }

    // ✅ Get All Bookings
    @GetMapping("/all")
    public List<BookingResponseDto> getAll() {
        return bookingService.findAllAirport(); // your method name
    }

    // ✅ Cancel Booking
    @PutMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "Booking cancelled successfully";
    }
}
