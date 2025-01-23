package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// UserRepository interface for CRUD operations on User entities
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by username
    User findByUsername(String username);
}