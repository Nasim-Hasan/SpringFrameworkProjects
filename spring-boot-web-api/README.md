# Spring Boot Web API

This project is a Spring Boot Web API that provides endpoints for user authentication, product management, and cart management. It utilizes Object Relational Mapping (ORM) for database interactions and follows standard coding conventions for Spring Boot applications.

## Project Structure

```
spring-boot-web-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── SpringBootWebApiApplication.java  # Main entry point of the application
│   │   │           ├── controller
│   │   │           │   ├── AuthController.java           # Handles authentication endpoints
│   │   │           │   ├── ProductController.java        # Handles product-related endpoints
│   │   │           │   └── CartController.java           # Handles cart management endpoints
│   │   │           ├── model
│   │   │           │   ├── Product.java                   # Represents product entity
│   │   │           │   ├── User.java                      # Represents user entity
│   │   │           │   └── Cart.java                      # Represents shopping cart entity
│   │   │           ├── repository
│   │   │           │   ├── ProductRepository.java         # Repository for Product entity
│   │   │           │   ├── UserRepository.java            # Repository for User entity
│   │   │           │   └── CartRepository.java            # Repository for Cart entity
│   │   │           ├── service
│   │   │           │   ├── AuthService.java               # Business logic for authentication
│   │   │           │   ├── ProductService.java            # Business logic for product management
│   │   │           │   └── CartService.java               # Business logic for cart management
│   │   │           └── config
│   │   │               └── SecurityConfig.java            # Security configuration for the application
│   │   └── resources
│   │       ├── application.properties                      # Application configuration properties
│   │       └── data.sql                                    # SQL for initializing the database
├── pom.xml                                                 # Maven configuration file
└── README.md                                               # Project documentation
```

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd spring-boot-web-api
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the API**:
   The API will be available at `http://localhost:8080`.

## Usage Guidelines

- **Authentication**:
  - Use the `/auth/login` endpoint to log in.
  - Use the `/auth/register` endpoint to register a new user.

- **Product Management**:
  - Use the `/products` endpoint to retrieve all products.
  - Use the `/products/{id}` endpoint to retrieve a specific product by ID.

- **Cart Management**:
  - Use the `/cart` endpoint to manage the shopping cart, including adding and removing items.

## Dependencies

This project uses the following dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Security
- H2 Database (for development and testing)

## License

This project is licensed under the MIT License. See the LICENSE file for more details.