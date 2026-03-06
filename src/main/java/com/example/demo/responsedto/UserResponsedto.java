package com.example.demo.responsedto;

import java.time.LocalDateTime;
import java.util.UUID;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class UserResponsedto {
	 private UUID uuid;
	    private String userName;
	    private String userAddress;
	    private Integer userAge;
	    private String gender;
	    private LocalDateTime createdOn;
}
