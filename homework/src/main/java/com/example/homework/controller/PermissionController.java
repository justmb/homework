package com.example.homework.controller;

import com.example.homework.entity.Permission;
import com.example.homework.entity.User;
import com.example.homework.service.PermissionServiceImpl;
import com.example.homework.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PermissionController {
    private final PermissionServiceImpl permissionService;

    @Autowired
    public PermissionController(PermissionServiceImpl permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/permission/get")
    public ResponseEntity<List<Permission>> getUsers(@RequestHeader(name = "username", required = false) String username ) {
        return ResponseEntity.ok(permissionService.getAll(username));
    }

    @PostMapping("/permission/add")
    public void addPermission(@RequestBody Permission permission) {
        permissionService.addPermission(permission);
    }

    @DeleteMapping("/permission/delete/{permissionId}")
    public void deleteUser(@PathVariable Long permissionId){
        permissionService.deletePermissionById(permissionId);
    }
}
