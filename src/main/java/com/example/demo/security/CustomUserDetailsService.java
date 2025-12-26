package com.example.demo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

    // In-memory users (TEST EXPECTS THIS)
    private final Map<String, DemoUser> users = new HashMap<>();

    // ✅ DEFAULT ADMIN (TEST EXPECTS THIS)
    public CustomUserDetailsService() {
        users.put("admin@city.com",
                new DemoUser(1L, "Admin", "admin@city.com", "admin123", "ADMIN"));
    }

    // ===================== INNER CLASS =====================
    public static class DemoUser {
        private Long id;
        private String fullName;
        private String email;
        private String password;
        private String role;

        public DemoUser(Long id, String fullName, String email, String password, String role) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public Long getId() { return id; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getRole() { return role; }
    }

    // ===================== REQUIRED BY TEST =====================
    public DemoUser getByEmail(String email) {
        DemoUser user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public DemoUser registerUser(String fullName, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }
        DemoUser user = new DemoUser(
                (long) (users.size() + 1),
                fullName,
                email,
                password,
                "USER"
        );
        users.put(email, user);
        return user;
    }

    // ===================== SPRING SECURITY =====================
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        DemoUser user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
