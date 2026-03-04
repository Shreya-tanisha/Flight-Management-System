package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.entity.User;
import com.example.demo.requestdto.UserRequestdto;
import com.example.demo.responsedto.UserResponsedto;

public interface UserService {
	User save(UserRequestdto dto);
	UserResponsedto getById(UUID id);
	List<UserResponsedto> findAll();
	UserResponsedto update(UUID id,UserRequestdto dto);
	void delete (UUID id);

}
