package com.ezytek.software.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "aircraft", uniqueConstraints = {
        @UniqueConstraint(columnNames = "registrationNumber")
})
public class Aircraft {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String model;
	@Column(nullable=false,unique=true)
	private String registrationNumber;
	private String manufacturer;
	private Integer totalSeats;
	private Integer economySeats;
	private Integer businessSeats;
	private Boolean active=true;
	private LocalDateTime createdAt;
	 @PrePersist
	    public void onCreate() {
	        this.createdAt = LocalDateTime.now();
	    }
}
