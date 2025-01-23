package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configures the authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() // Using in-memory authentication for simplicity
            .withUser("user").password(passwordEncoder().encode("password")).roles("USER") // Example user
            .and()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN"); // Example admin
    }

    // Configures HTTP security settings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disabling CSRF for simplicity
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll() // Allowing access to authentication endpoints
            .anyRequest().authenticated() // All other requests require authentication
            .and()
            .httpBasic(); // Using basic authentication
    }

    // Bean for password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Using BCrypt for password encoding
    }

    // Bean for authentication manager
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); // Exposing the authentication manager as a bean
    }
}