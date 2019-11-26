package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    Person findPersonById(String id);

    List<Person> findAllPerson();

    List<Person> savePersonList(List<Person> personList0);

    void deletePerson(String id);

}
