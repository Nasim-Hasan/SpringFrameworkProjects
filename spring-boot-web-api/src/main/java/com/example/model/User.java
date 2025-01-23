package com.example.model;

// User class representing the user entity
public class User {
    
    // Unique identifier for the user
    private Long id;
    
    // Username of the user
    private String username;
    
    // Password of the user
    private String password;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}