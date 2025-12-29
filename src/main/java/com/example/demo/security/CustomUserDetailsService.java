package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, DemoUser> users = new HashMap<>();

    // 🔹 Default admin user (required by tests)
    public CustomUserDetailsService() {
        DemoUser admin = new DemoUser(
                1L,
                "Admin",
                "admin@city.com",
                "admin123",
                "ADMIN"
        );
        users.put(admin.getEmail(), admin);
    }

    // ===== REQUIRED BY TESTS =====

    public DemoUser getByEmail(String email) {
        DemoUser user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public DemoUser registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }

        DemoUser user = new DemoUser(
                (long) (users.size() + 1),
                name,
                email,
                password,
                "USER"
        );

        users.put(email, user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return getByEmail(email);
    }

    // ===== INNER CLASS REQUIRED BY TESTS =====
    public static class DemoUser implements UserDetails {

        private Long id;
        private String name;
        private String email;
        private String password;
        private String role;

        public DemoUser(Long id, String name, String email, String password, String role) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public Long getId() { return id; }
        public String getEmail() { return email; }
        public String getRole() { return role; }

        @Override
        public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
            return List.of(() -> "ROLE_" + role);
        }

        @Override public String getPassword() { return password; }
        @Override public String getUsername() { return email; }
        @Override public boolean isAccountNonExpired() { return true; }
        @Override public boolean isAccountNonLocked() { return true; }
        @Override public boolean isCredentialsNonExpired() { return true; }
        @Override public boolean isEnabled() { return true; }
    }
}
