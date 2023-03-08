package com.example.springboottest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springboottest.model.Student;
import com.example.springboottest.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
   
     @PostMapping("/students")
    public ResponseEntity<Object> createStudent() {
        studentService.createStudent();
      
		 URI location =ServletUriComponentsBuilder.fromCurrentRequest().build().toUri(); 
		 
		 System.out.println("Students Created Successfully");
		 
		 return ResponseEntity.created(location).build();
		 
     }
    
    @GetMapping("/students/{studentId}")
    public Student retrieveStudent(@PathVariable Integer studentId) {
        return studentService.retrieveStudent(studentId);
       
    }

}
