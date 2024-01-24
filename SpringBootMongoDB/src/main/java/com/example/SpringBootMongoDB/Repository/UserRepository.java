package com.example.SpringBootMongoDB.Repository;

import com.example.SpringBootMongoDB.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByAge(int age);
    List<User> findByName(String name);
}
