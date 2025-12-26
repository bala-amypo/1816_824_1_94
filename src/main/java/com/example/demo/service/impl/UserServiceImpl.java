/*
 * File: UserServiceImpl.java
 * Package: com.example.demo.service.impl
 * Purpose: Implementation of UserService
 */
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User registerUser(String fullName, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BadRequestException("email");
        }

        User user = new User(
                fullName,
                email,
                passwordEncoder.encode(password),
                "USER"
        );

        return userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public boolean exists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
