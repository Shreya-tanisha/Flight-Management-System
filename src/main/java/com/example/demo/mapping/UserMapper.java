package com.example.demo.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.requestdto.UserRequestdto;
import com.example.demo.responsedto.UserResponsedto;

@Component
public class UserMapper {
	public  User toEntity(UserRequestdto dto) {
		User user=new User();
		user.setUserName(dto.getUserName());
		user.setUserAge(dto.getUserAge());
		user.setCreatedOn(LocalDateTime.now());
		user.setGender(dto.getGender());
		user.setUserAddress(dto.getUserAddress());
		user.setCreatedBy("SYSTEM");
		return user;
	}
	public UserResponsedto toResponse(User user) {
		UserResponsedto ur=new UserResponsedto();
		ur.setUuid(user.getUuid());
		ur.setUserName(user.getUserName());
		ur.setGender(user.getGender());
		ur.setCreatedOn(user.getCreatedOn());
		ur.setUserAddress(user.getUserAddress());
		ur.setUserAddress(user.getUserAddress());
		
		return ur;
	}

}
