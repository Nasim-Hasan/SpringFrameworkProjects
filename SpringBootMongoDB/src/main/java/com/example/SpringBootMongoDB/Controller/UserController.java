package com.example.SpringBootMongoDB.Controller;

import com.example.SpringBootMongoDB.Model.User;
import com.example.SpringBootMongoDB.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    private User user=new User();

    @PostMapping("/user")
    public void saveUser(@RequestBody Map<String, String> body){
        String id = body.get("id");
        String name = body.get("name");
        int age = Integer.parseInt(body.get("age"));
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        service.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
        return service.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id){
        service.deleteUser(id);
    }

    @PostMapping("/find_age")
    public List<User> findByAge(@RequestBody Map<String, Integer> body){
        int age = body.get("age");
        return service.findByAge(age);
    }

    @GetMapping("/find_name/{name}")
    public List<User> findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody Map<String,String>body){
        String id = body.get("id");
        String name = body.get("name");
        int age = Integer.parseInt(body.get("age"));
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        service.updateUser(user);
    }

    @PatchMapping("/user/{id}")
    public void partialUpdateUser(@PathVariable String id,@RequestBody Map<String,String>body){
         User user=service.getUser(id); // Selecting a Particular User
         Set<String> keys = body.keySet();
        for(String tmpKey:keys){
            if(tmpKey.equalsIgnoreCase("name")){
                String name = body.get("name");
                user.setName(name);
            }
            else if(tmpKey.equalsIgnoreCase("age")){
                int age = Integer.parseInt(body.get("age"));
                user.setAge(age);
            }
        }
        service.updateUser(user);
    }
}
