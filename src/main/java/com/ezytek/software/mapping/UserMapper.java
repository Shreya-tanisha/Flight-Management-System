package com.ezytek.software.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ezytek.software.entity.User;
import com.ezytek.software.requestdto.UserRequestDto;
import com.ezytek.software.responsedto.UserResponseDto;

@Component
public class UserMapper {
	public  User toEntity(UserRequestDto dto) {
		User user=new User();
		user.setUserName(dto.getUserName());
		user.setUserAge(dto.getUserAge());
		user.setCreatedOn(LocalDateTime.now());
		user.setGender(dto.getGender());
		user.setUserAddress(dto.getUserAddress());
		user.setCreatedBy("SYSTEM");
		return user;
	}
	public UserResponseDto toResponse(User user) {
		UserResponseDto ur=new UserResponseDto();
		ur.setUuid(user.getUuid());
		ur.setUserName(user.getUserName());
		ur.setGender(user.getGender());
		ur.setCreatedOn(user.getCreatedOn());
		ur.setUserAddress(user.getUserAddress());
		ur.setUserAddress(user.getUserAddress());
		
		return ur;
	}

}
