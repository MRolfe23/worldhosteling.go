package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Person;
import com.worldhosteling.go.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    public PersonController() {}

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getAllPersons() {
        return personService.findAllPerson();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        Person foundPerson = personService.findPersonById(id);
        if (foundPerson == null) {
            logger.error("Person with id: " + id + " was not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundPerson);
    }

    @PostMapping("/")
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PostMapping("/{id}")
    public void deletePersonById(@PathVariable String id) {
        personService.deletePerson(id);
    }

}
