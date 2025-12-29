package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public AuthController(
            JwtTokenProvider jwtTokenProvider,
            CustomUserDetailsService userDetailsService
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public CustomUserDetailsService.DemoUser register(@RequestBody User user) {
        return userDetailsService.registerUser(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        var demoUser = userDetailsService.getByEmail(user.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        demoUser.getEmail(),
                        null,
                        Collections.emptyList()
                );

        String token = jwtTokenProvider.generateToken(
                auth,
                demoUser.getId(),
                demoUser.getRole(),
                demoUser.getEmail()
        );

        return Map.of("token", token);
    }
}
