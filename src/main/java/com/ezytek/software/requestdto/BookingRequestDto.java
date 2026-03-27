package com.ezytek.software.requestdto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingRequestDto {
    private Long flightId;
    private Long userId;

    private String seatNumber;
    private String seatClass;

    private BigDecimal pricePaid;
}
