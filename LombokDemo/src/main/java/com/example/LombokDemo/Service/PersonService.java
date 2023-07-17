package com.example.LombokDemo.Service;

import com.example.LombokDemo.Entity.Person;
import java.util.List;

public interface PersonService {
    void save(Person person);
    List<Person> getPersonList();
}
