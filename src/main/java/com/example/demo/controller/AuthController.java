package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserService userService,
                          JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User saved = userService.register(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {
        User user = userService.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = tokenProvider.generateToken(user.getEmail(), user.getRole());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
