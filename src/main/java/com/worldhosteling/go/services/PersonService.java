package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person savePerson(Person person);

    Optional<Person> findPersonById(String id);

    List<Person> findAllPerson();

    List<Person> savePersonList(List<Person> personList0);

    void deletePerson(String id);

}
