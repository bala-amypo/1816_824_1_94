package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    /* =========================================================
       REQUIRED BY TESTNG
       ========================================================= */
    public CustomUserDetailsService() {
        // no-arg constructor required by tests
    }

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* =========================================================
       SPRING SECURITY METHOD
       ========================================================= */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    /* =========================================================
       METHODS EXPECTED BY TESTNG
       ========================================================= */

    public DemoUser getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return new DemoUser(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

    public DemoUser registerUser(String fullName,
                                 String email,
                                 String password) {

        User user = new User(fullName, email, password, "USER");
        user = userRepository.save(user);

        return new DemoUser(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

    /* =========================================================
       INNER CLASS REQUIRED BY TESTS
       ========================================================= */
    public static class DemoUser {

        private Long id;
        private String email;
        private String role;

        public DemoUser(Long id, String email, String role) {
            this.id = id;
            this.email = email;
            this.role = role;
        }

        public Long getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }
    }
}
