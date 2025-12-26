package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Date;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs = 3600000; // 1 hour

    public JwtTokenProvider(String secret) {
        this.secret = secret;
    }

    // ================= REQUIRED BY TEST =================
    public String generateToken(
            UsernamePasswordAuthenticationToken auth,
            Long userId,
            String role,
            String email) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
