package com.example.LombokDemo.Repository;

import com.example.LombokDemo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
