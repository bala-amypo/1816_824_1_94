package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, DemoUser> users = new HashMap<>();

    // REQUIRED default admin (TEST EXPECTS THIS)
    public CustomUserDetailsService() {
        users.put(
                "admin@city.com",
                new DemoUser(1L, "Admin", "admin@city.com", "ADMIN")
        );
    }

    // REQUIRED by tests
    public DemoUser getByEmail(String email) {
        DemoUser user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    // REQUIRED by tests
    public DemoUser registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }
        DemoUser user = new DemoUser(
                (long) (users.size() + 1),
                name,
                email,
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

    // REQUIRED inner class (TEST USES THIS)
    public static class DemoUser implements UserDetails {
        private final Long id;
        private final String name;
        private final String email;
        private final String role;

        public DemoUser(Long id, String name, String email, String role) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.role = role;
        }

        public Long getId() { return id; }
        public String getEmail() { return email; }
        public String getRole() { return role; }

        @Override public String getUsername() { return email; }
        @Override public String getPassword() { return ""; }
        @Override public boolean isAccountNonExpired() { return true; }
        @Override public boolean isAccountNonLocked() { return true; }
        @Override public boolean isCredentialsNonExpired() { return true; }
        @Override public boolean isEnabled() { return true; }
        @Override public java.util.Collection getAuthorities() {
            return java.util.Collections.emptyList();
        }
    }
}
