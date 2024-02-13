package com.example.SpringBootSecurityDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @GetMapping("/home")
    public String helloHome() {
        return "Hello Home";
    }
}
