package com.example.fooddelivery.service;

import com.example.fooddelivery.model.User;
import com.example.fooddelivery.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
