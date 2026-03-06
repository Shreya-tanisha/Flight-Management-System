package com.example.demo.service;

import java.time.LocalDateTime;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserResponse.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapping.UserMapper;
import com.example.demo.requestdto.UserRequestdto;
import com.example.demo.responsedto.UserResponsedto;
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
	public User save(UserRequestdto dto) {
		
		User user=usermap.toEntity(dto);
		// TODO Auto-generated method stub
		return ur.save(user);
	}

	@Override
	public UserResponsedto getById(UUID id) {
		  User user = ur.findById(id)
		            .orElseThrow(() -> 
		                new ResourceNotFoundException("User not found with id: " + id)
		            );

		    return usermap.toResponse(user);
	}

	@Override
	public List<UserResponsedto> findAllUser() {

		    return ur.findAll()
		            .stream()
		            .map(usermap::toResponse)
		            .toList();   
		}
	

	@Override
	public UserResponsedto update(UUID id, UserRequestdto dto) {
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
