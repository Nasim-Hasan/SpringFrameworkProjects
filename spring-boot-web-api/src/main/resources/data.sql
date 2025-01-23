-- SQL script to create the User table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- SQL script to create the Product table
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
);

-- SQL script to create the Cart table
CREATE TABLE IF NOT EXISTS carts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- SQL script to create a sample user
INSERT INTO users (username, password) VALUES ('testuser', 'password123');

-- SQL script to create sample products
INSERT INTO products (name, description, price) VALUES 
('Product 1', 'Description for Product 1', 19.99),
('Product 2', 'Description for Product 2', 29.99),
('Product 3', 'Description for Product 3', 39.99);