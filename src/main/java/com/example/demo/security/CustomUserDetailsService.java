package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {

    private final Map<String, DemoUser> users = new HashMap<>();

    public CustomUserDetailsService() {
        users.put("admin@city.com",
                new DemoUser(1L, "Admin", "admin@city.com", "ADMIN"));
    }

    public DemoUser getByEmail(String email) {
        DemoUser user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public DemoUser registerUser(String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }
        DemoUser user =
                new DemoUser((long) (users.size() + 1), name, email, "USER");
        users.put(email, user);
        return user;
    }

    public Object loadUserByUsername(String email) {
        return getByEmail(email);
    }

    // used in tests
    public static class DemoUser {
        private Long id;
        private String name;
        private String email;
        private String role;

        public DemoUser(Long id, String name, String email, String role) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.role = role;
        }

        public Long getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getRole() { return role; }
    }
}
