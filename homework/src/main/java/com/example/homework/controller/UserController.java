package com.example.homework.controller;

import com.example.homework.entity.User;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api")
public class UserController {

    private final UserService userServices;

    @Autowired
    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getUsers() {
        return userServices.getUsers();
    }

    @PostMapping
    public void addStudent(@RequestBody User user) {
        userServices.addUser(user);
    }
}
