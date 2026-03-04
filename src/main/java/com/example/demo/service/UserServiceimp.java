package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserResponse.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.mapping.UserMapper;
import com.example.demo.requestdto.UserRequestdto;
import com.example.demo.responsedto.UserResponsedto;
@Service
public class UserServiceimp implements UserService{
@Autowired
UserRepository ur;
@Autowired
UserMapper usermap;
	@Override
	public User save(UserRequestdto dto) {
		
		User user=usermap.toEntity(dto);
		// TODO Auto-generated method stub
		return ur.save(user);
	}

	@Override
	public UserResponsedto getById(UUID id) {
		// TODO Auto-generated method stub
		Optional<User> byId = ur.findById(id);
		UserResponsedto response = usermap.toResponse(byId.get());
		return response;
	}

	@Override
	public List<UserResponsedto> findAll() {
		// TODO Auto-generated method stub
		List<User> list = ur.findAll();
		List<UserResponsedto> dlist=new ArrayList<>();
		for(User u:list) {
			dlist.add(usermap.toResponse(u));
		}
		return dlist;
	}

	@Override
	public UserResponsedto update(UUID id, UserRequestdto dto) {
		// TODO Auto-generated method stub
		Optional<User> byId = ur.findById(id);
		User user = byId.get();
		user.setUserName(dto.getUserName());
		user.setUserAddress(dto.getUserAddress());
		user.setUserAge(dto.getUserAge());
		user.setGender(dto.getGender());
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
