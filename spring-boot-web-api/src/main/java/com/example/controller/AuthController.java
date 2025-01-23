package com.example.controller;

import com.example.model.User;
import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller for handling authentication-related requests
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // Call the AuthService to register the user
        authService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Call the AuthService to authenticate the user
        String token = authService.login(user);
        return ResponseEntity.ok(token);
    }
}