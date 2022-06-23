package com.example.homework.service;

import com.example.homework.entity.User;
import com.example.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll(String permissionName) {
        if(permissionName == null){
            return userRepository.findAll();
        }else {
            return userRepository.findByUserPermission_Name(permissionName);
        }
    }

    public void addUser(User user) {
        boolean existUser =
                userRepository.existUserByEmail(user.getEmail());
        if (existUser) {
            throw new IllegalStateException("User existed");
        }
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        boolean exist = userRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("The customer with " + id + " not exist");
        }else{
            userRepository.deleteById(id);
        }
    }
}
