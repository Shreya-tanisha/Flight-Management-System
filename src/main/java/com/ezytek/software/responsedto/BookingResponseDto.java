package com.ezytek.software.responsedto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BookingResponseDto {

    private Long id;
    private String bookingReference;

    private String flightInfo;
    private String userName;

    private String seatNumber;
    private String seatClass;

    private BigDecimal pricePaid;

    private String bookingStatus;
    private String paymentStatus;

    private LocalDateTime bookingTime;
}
