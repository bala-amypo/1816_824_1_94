package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, DemoUser> users = new HashMap<>();

    // ✅ REQUIRED BY TESTS
    public DemoUser registerUser(String email, String password, String role) {
        DemoUser user = new DemoUser(email, password, role);
        users.put(email, user);
        return user;
    }

    // ✅ REQUIRED BY TESTS
    public DemoUser getByEmail(String email) {
        return users.get(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        DemoUser user = users.get(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    // ✅ INNER CLASS REQUIRED BY TESTS
    public static class DemoUser {
        private final String email;
        private final String password;
        private final String role;

        public DemoUser(String email, String password, String role) {
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getRole() { return role; }
    }
}
