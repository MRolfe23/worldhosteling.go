package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Person;
import com.worldhosteling.go.repository.PersonRepository;
import com.worldhosteling.go.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return null;
    }

    @Override
    public void deletePerson(String id) {

    }

    @Override
    public Person findPersonById(String id) {
        return null;
    }

    @Override
    public List<Person> findAllPerson() {
        return null;
    }

    @Override
    public List<Person> savePersonList(List<Person> personList0) {
        return null;
    }

}
