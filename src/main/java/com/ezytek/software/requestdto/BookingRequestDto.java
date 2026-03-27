package com.ezytek.software.requestdto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BookingRequestDto {
    private Long flightId;
    private UUID userId;

    private String seatNumber;
    private String seatClass;

    private BigDecimal pricePaid;
}
