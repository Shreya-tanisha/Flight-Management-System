package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="airports")
public class Airport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true,nullable=false)
	private String code;

    private String name;
    private String city;
    private String country;
    private String timezone;
    private Boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
