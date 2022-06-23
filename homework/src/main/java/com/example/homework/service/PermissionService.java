package com.example.homework.service;

import com.example.homework.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getAll(String userName);

}
