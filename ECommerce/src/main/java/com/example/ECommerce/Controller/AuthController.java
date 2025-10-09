package com.example.ECommerce.Controller;

import com.example.ECommerce.Service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login(@PathVariable String email, @PathVariable String password) {
        return authService.authenticate(email,password);
    }

}
