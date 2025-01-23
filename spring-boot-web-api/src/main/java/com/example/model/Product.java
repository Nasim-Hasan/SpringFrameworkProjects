package com.example.model;

// This class represents the Product entity with its properties
public class Product {
    
    // Unique identifier for the product
    private Long id;
    
    // Name of the product
    private String name;
    
    // Description of the product
    private String description;
    
    // Price of the product
    private Double price;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}