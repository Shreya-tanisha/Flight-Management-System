package com.ezytek.software.responsedto;

import java.time.LocalDateTime;
import java.util.UUID;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class UserResponseDto {
	 private UUID uuid;
	    private String userName;
	    private String userAddress;
	    private Integer userAge;
	    private String gender;
	    private LocalDateTime createdOn;
}
