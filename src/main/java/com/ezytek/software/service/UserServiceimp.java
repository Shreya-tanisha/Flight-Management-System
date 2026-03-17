package com.ezytek.software.service;

import java.time.LocalDateTime;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezytek.software.UserResponse.UserRepository;
import com.ezytek.software.entity.User;
import com.ezytek.software.exception.ResourceNotFoundException;
import com.ezytek.software.mapping.UserMapper;
import com.ezytek.software.requestdto.UserRequestDto;
import com.ezytek.software.responsedto.UserResponseDto;
@Service
public class UserServiceimp implements UserService{
@Autowired
private final UserRepository ur;
@Autowired
private final UserMapper usermap;
public UserServiceimp(UserRepository ur, UserMapper usermap) {
    this.ur = ur;
    this.usermap = usermap;
}
	@Override
	public User save(UserRequestDto dto) {
		
		User user=usermap.toEntity(dto);
		// TODO Auto-generated method stub
		return ur.save(user);
	}

	@Override
	public UserResponseDto getById(UUID id) {
		  User user = ur.findById(id)
		            .orElseThrow(() -> 
		                new ResourceNotFoundException("User not found with id: " + id)
		            );

		    return usermap.toResponse(user);
	}

	@Override
	public List<UserResponseDto> findAllUser() {

		    return ur.findAll()
		            .stream()
		            .map(usermap::toResponse)
		            .toList();   
		}
	

	@Override
	public UserResponseDto update(UUID id, UserRequestDto dto) {
		// TODO Auto-generated method stub
		User user= ur.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("User not found with id: " + id)
);
				
		BeanUtils.copyProperties(dto, user, "id", "createdOn");

		user.setModifiedOn(LocalDateTime.now());
        user.setModifiedBy("SYSTEM");
		return usermap.toResponse(ur.save(user));
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
	}

}
