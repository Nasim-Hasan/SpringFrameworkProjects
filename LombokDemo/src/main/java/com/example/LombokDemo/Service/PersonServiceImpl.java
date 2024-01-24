package com.example.LombokDemo.Service;

import com.example.LombokDemo.Entity.Person;
import com.example.LombokDemo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personrepo;
    /*private final PersonRepository personrepo;
    public PersonServiceImpl(PersonRepository personrepo) {
        this.personrepo = personrepo;
    }*/

    @Override
    public void save(Person person) {
        personrepo.save(person);
    }

    @Override
    public List<Person> getPersonList() {
        return personrepo.findAll();
    }
}
