package com.example.persondemo.controller;

import com.example.persondemo.entity.Person;
import com.example.persondemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//client -> server
//server (chrome browser localhost):63512 -> server (localhost:8080)

@CrossOrigin
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") Long id) {

        return personRepository.findById(id).orElse(null);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {

        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public List<Person> addPerson(@RequestBody Person person) {

        personRepository.save(person);
        return personRepository.findAll();
    }
}
