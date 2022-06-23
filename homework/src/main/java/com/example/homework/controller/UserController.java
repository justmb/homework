package com.example.homework.controller;

import com.example.homework.entity.User;
import com.example.homework.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api")
public class UserController {

    private final UserServiceImpl userServicesImpl;

    @Autowired
    public UserController(UserServiceImpl userServicesImpl) {
        this.userServicesImpl = userServicesImpl;
    }

    @GetMapping("/user/get")
    public ResponseEntity<List<User>> getUsers(@RequestHeader(name = "permissionName", required = false) String permissionName ) {
        return ResponseEntity.ok(userServicesImpl.getAll(permissionName));
    }

    @PostMapping("/user/add")
    public void addStudent(@RequestBody User user) {
        userServicesImpl.addUser(user);
    }

    @DeleteMapping("/user/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userServicesImpl.deleteUserById(userId);
    }

}
