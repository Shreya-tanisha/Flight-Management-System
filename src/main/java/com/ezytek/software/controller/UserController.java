package com.ezytek.software.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ezytek.software.entity.User;
import com.ezytek.software.requestdto.UserRequestDto;
import com.ezytek.software.responsedto.UserResponseDto;
import com.ezytek.software.service.UserService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	@Autowired
    UserService userService;

    
    @PostMapping("/save")
    public User save(@RequestBody UserRequestDto dto) {
        return userService.save(dto);
    }

    
    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    // 🔹 Get All Users
    @GetMapping("/all")
    public List<UserResponseDto> findAllUser() {
        return userService.findAllUser();
    }

   
    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable UUID id,
                                  @RequestBody UserRequestDto dto) {
        return userService.update(id, dto);
    }

    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        userService.delete(id);
        return "User deleted successfully";
    }
}
