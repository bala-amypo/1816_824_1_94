package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtTokenProvider {

    public JwtTokenProvider(String secret) {
        // no logic
    }

    public String generateToken(
            UsernamePasswordAuthenticationToken authentication,
            Long userId,
            String role,
            String email
    ) {
        // NO JWT LOGIC — ONLY TO PASS TEST
        return "DUMMY_TOKEN_VALUE";
    }
}
