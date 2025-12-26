/*
 * File: UserController.java
 * Package: com.example.demo.controller
 * Purpose: REST endpoints for User management (lookup & existence check)
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection only (NO @Autowired)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * Get user details by email
     * URL: GET /api/users/email/{email}
     */
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    /*
     * Check if user exists by email
     * URL: GET /api/users/exists/{email}
     */
    @GetMapping("/exists/{email}")
    public boolean userExists(@PathVariable String email) {
        return userService.exists(email);
    }
}
