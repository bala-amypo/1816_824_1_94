package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private String secret = "test-secret-key";   // default for tests
    private final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours

    /* =========================================================
       REQUIRED BY TESTNG
       ========================================================= */
    public JwtTokenProvider() {
    }

    public JwtTokenProvider(String secret) {
        this.secret = secret;
    }

    /* =========================================================
       PRIMARY TOKEN GENERATOR (EXPECTED BY TESTS)
       ========================================================= */
    public String generateToken(Long userId, String email, String role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /* =========================================================
       OVERLOADED METHOD REQUIRED BY TESTNG
       ========================================================= */
    public String generateToken(
            UsernamePasswordAuthenticationToken authentication,
            Long userId,
            String email,
            String role) {

        return generateToken(userId, email, role);
    }

    /* =========================================================
       OPTIONAL HELPERS (SAFE)
       ========================================================= */
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
