package com.adamidis.learning.presencesystem.service;

import com.adamidis.learning.presencesystem.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto registerUser(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto update(UserDto userDto);

    void delete(Integer id);
}
