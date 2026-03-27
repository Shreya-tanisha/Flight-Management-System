package com.ezytek.software.UserResponse;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezytek.software.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}