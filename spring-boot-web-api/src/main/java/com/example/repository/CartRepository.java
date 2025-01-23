package com.example.repository;

import com.example.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CartRepository interface for CRUD operations on Cart entities
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional query methods can be defined here if needed
}