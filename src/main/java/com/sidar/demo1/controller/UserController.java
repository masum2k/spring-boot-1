package com.sidar.demo1.controller;

import com.sidar.demo1.core.config.ModelMapperConfig;
import com.sidar.demo1.dtos.UserSaveRequest;
import com.sidar.demo1.entity.User;
import com.sidar.demo1.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserController(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserSaveRequest userSaveRequest) {
        User user1 = this.modelMapper.map(userSaveRequest, User.class);
        return this.userRepository.save(user1);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}