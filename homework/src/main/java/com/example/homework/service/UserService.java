package com.example.homework.service;

import com.example.homework.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll(String permissionName);
}
