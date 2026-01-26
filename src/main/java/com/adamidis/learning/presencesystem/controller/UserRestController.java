package com.adamidis.learning.presencesystem.controller;

import com.adamidis.learning.presencesystem.dto.UserDto;
import com.adamidis.learning.presencesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "Deleted user id - " + id;
    }
}
