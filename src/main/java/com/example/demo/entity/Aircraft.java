package com.example.demo.entity;

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
<<<<<<< HEAD

@Entity
@Data
=======
@Data
@Entity
>>>>>>> 3b87fad (Added Aircraft module (entity, controller, service, repository, dto, mapper))
@Table(name = "aircraft", uniqueConstraints = {
        @UniqueConstraint(columnNames = "registrationNumber")
})
public class Aircraft {
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String model;
	@Column(nullable=false,unique=true)
	private String registrationNumber;
	private Integer totalSeats;
	private Integer economySeats;
	private Integer businessSeats;
	private Boolean active=true;
	private LocalDateTime createAt;
	 @PrePersist
	    public void onCreate() {
	        this.createAt = LocalDateTime.now();
	    }

	

=======

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String model;
	    private String manufacturer;

	    @Column(nullable = false, unique = true)
	    private String registrationNumber;

	    private Integer totalSeats;
	    private Integer economySeats;
	    private Integer businessSeats;

	    private Boolean active = true;

	    private LocalDateTime createdAt;

	    @PrePersist
	    public void onCreate() {
	        this.createdAt = LocalDateTime.now();
	    }

>>>>>>> 3b87fad (Added Aircraft module (entity, controller, service, repository, dto, mapper))
}
