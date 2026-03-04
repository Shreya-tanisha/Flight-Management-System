package com.example.demo.controller;

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


import com.example.demo.entity.User;
import com.example.demo.requestdto.UserRequestdto;
import com.example.demo.responsedto.UserResponsedto;
import com.example.demo.service.UserService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	@Autowired
    UserService userService;

    
    @PostMapping("/save")
    public User save(@RequestBody UserRequestdto dto) {
        return userService.save(dto);
    }

    
    @GetMapping("/{id}")
    public UserResponsedto getById(@PathVariable UUID id) {
        return userService.getById(id);
    }


    @GetMapping("/all")
    public List<UserResponsedto> findAllUser() {
        return userService.findAllUser();
    }

   
    @PutMapping("/{id}")
    public UserResponsedto update(@PathVariable UUID id,
                                  @RequestBody UserRequestdto dto) {
        return userService.update(id, dto);
    }

    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        userService.delete(id);
        return "User deleted successfully";
    }
}
