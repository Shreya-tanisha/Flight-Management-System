package com.ezytek.software.mapping;

import com.ezytek.software.entity.Booking;
import com.ezytek.software.entity.Flight;
import com.ezytek.software.entity.User;
import com.ezytek.software.enums.BookingStatus;
import com.ezytek.software.enums.PaymentStatus;
import com.ezytek.software.enums.SeatClass;
import com.ezytek.software.requestdto.BookingRequestDto;
import com.ezytek.software.responsedto.BookingResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookingMapper {
    public Booking toEntity(BookingRequestDto dto, Flight flight, User user){
        Booking booking=new Booking();
        BeanUtils.copyProperties(dto,booking);
        booking.setFlight(flight);
        booking.setUser(user);

        booking.setSeatClass(SeatClass.valueOf(dto.getSeatClass()));

        booking.setBookingReference("PNR" + System.currentTimeMillis());

        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setPaymentStatus(PaymentStatus.PAID);

        booking.setBookingTime(LocalDateTime.now());

        return booking;
    }
    public BookingResponseDto toResponse(Booking booking){
        BookingResponseDto dto=new BookingResponseDto();
        BeanUtils.copyProperties(booking, dto);

        dto.setSeatClass(booking.getSeatClass().name());
        dto.setBookingStatus(booking.getBookingStatus().name());
        dto.setPaymentStatus(booking.getPaymentStatus().name());

        dto.setFlightInfo(
                booking.getFlight().getRoute().getSourceAirport().getName()
                        + " → " +
                        booking.getFlight().getRoute().getDestinationAirport().getName()
        );

        dto.setUserName(booking.getUser().getUserName());

        return dto;
    }
}
