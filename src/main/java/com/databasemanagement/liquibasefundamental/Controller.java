package com.databasemanagement.liquibasefundamental;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/add")
    public String createPerson(@RequestParam String name) {
        personRepository.save(new Person(name, "180"));
        return personRepository.findByName(name) + "Saved successfully!";
    }

    @GetMapping("/person")
    public List<Person> getAllThePeople() {
        return (List<Person>) personRepository.findAll();
    }
}
