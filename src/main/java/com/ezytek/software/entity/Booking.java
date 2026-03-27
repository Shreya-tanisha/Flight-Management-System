package com.ezytek.software.entity;

import com.ezytek.software.enums.BookingStatus;
import com.ezytek.software.enums.PaymentStatus;
import com.ezytek.software.enums.SeatClass;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingReference; // PNR

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    private BigDecimal pricePaid;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime bookingTime;

    // 🔗 Relations
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
