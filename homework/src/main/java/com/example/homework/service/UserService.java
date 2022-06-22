package com.example.homework.service;

import com.example.homework.entity.User;
import com.example.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> studentByEmail =
                userRepository.findById(user.getId());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("User existed");
        }
        userRepository.save(user);
    }
}
