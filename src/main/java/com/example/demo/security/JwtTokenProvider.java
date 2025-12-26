package com.example.demo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtTokenProvider {

    public JwtTokenProvider(String secret) {
    }

    public String generateToken(
            UsernamePasswordAuthenticationToken authentication,
            Long userId,
            String role,
            String email
    ) {
        
        return "DUMMY_TOKEN_VALUE";
    }
}
