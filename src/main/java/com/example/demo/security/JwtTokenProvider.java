package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtTokenProvider {

    public JwtTokenProvider() {
    }

    public JwtTokenProvider(String secret) {
    }

    // required by AuthController + tests
    public String generateToken(
            UsernamePasswordAuthenticationToken auth,
            Long userId,
            String role,
            String email) {
        return "";
    }

    // required by AuthController
    public String generateToken(Long userId, String role, String email) {
        return "";
    }

    // required by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        return true;
    }

    // required by JwtAuthenticationFilter
    public String getEmailFromToken(String token) {
        return "";
    }
}
