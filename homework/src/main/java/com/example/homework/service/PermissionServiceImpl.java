package com.example.homework.service;

import com.example.homework.entity.Permission;
import com.example.homework.entity.User;
import com.example.homework.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> getAll(String userName) {
        if(userName == null){
            return permissionRepository.findAll();
        }else{
            return permissionRepository.findByUser_Name(userName);
        }
    }

    public void addPermission(Permission permission) {
        boolean existPermission =
                permissionRepository.existPermissionByName(permission.getName());
        if (existPermission) {
            throw new IllegalStateException("Permission existed");
        }
        permissionRepository.save(permission);
    }

    public void deletePermissionById(Long id){
        boolean exist = permissionRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("The permission with " + id + " not exist");
        }else{
            permissionRepository.deleteById(id);
        }
    }
}
