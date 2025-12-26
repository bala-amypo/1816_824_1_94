/*
 * File: LoginRequest.java
 * Package: com.example.demo.dto
 * Purpose: Request body for user login
 */
package com.example.demo.dto;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
