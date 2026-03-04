package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(updatable=false,nullable=false)
	private UUID uuid;
	private String userName;
	private String userAddress;
	private Integer userAge;
	 private String gender;

	    private LocalDateTime createdOn;
	    private String createdBy;
          @LastModifiedDate
	    private LocalDateTime modifiedOn;
          @CreatedDate
	    private String modifiedBy;

}
