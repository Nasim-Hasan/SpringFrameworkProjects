package com.example.service;

import com.example.model.Cart;
import com.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service class for managing the shopping cart
@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository; // Injecting CartRepository
    }

    // Method to get all carts
    public List<Cart> getAllCarts() {
        return cartRepository.findAll(); // Fetching all carts from the database
    }

    // Method to get a cart by user ID
    public Optional<Cart> getCartByUserId(Long userId) {
        return cartRepository.findById(userId); // Fetching cart by user ID
    }

    // Method to add a product to the cart
    public Cart addProductToCart(Long userId, Long productId) {
        Cart cart = cartRepository.findById(userId).orElse(new Cart(userId)); // Fetching or creating a new cart
        // Logic to add product to cart (not implemented here)
        return cartRepository.save(cart); // Saving the updated cart
    }

    // Method to remove a product from the cart
    public Cart removeProductFromCart(Long userId, Long productId) {
        Cart cart = cartRepository.findById(userId).orElseThrow(() -> new RuntimeException("Cart not found")); // Fetching cart
        // Logic to remove product from cart (not implemented here)
        return cartRepository.save(cart); // Saving the updated cart
    }
}