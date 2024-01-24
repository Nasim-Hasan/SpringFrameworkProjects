package com.example.SpringBootMongoDB.Service;

import com.example.SpringBootMongoDB.Model.User;
import com.example.SpringBootMongoDB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void saveUser(User user) {
        repository.save(user);
    }
    public User getUser(String id) {
        return repository.findById(id).orElse(null);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    public List<User> findByAge(int age){
        return repository.findByAge(age);
    }

    public List<User> findByName(String name){
        return repository.findByName(name);
    }

    public void updateUser(User user){
        repository.save(user);
    }
}
