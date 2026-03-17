package com.ezytek.software.service;

import java.util.List;
import java.util.UUID;

import com.ezytek.software.entity.User;
import com.ezytek.software.requestdto.UserRequestDto;
import com.ezytek.software.responsedto.UserResponseDto;

public interface UserService {
	User save(UserRequestDto dto);
	UserResponseDto getById(UUID id);
	List<UserResponseDto> findAllUser();
	UserResponseDto update(UUID id, UserRequestDto dto);
	void delete (UUID id);

}
