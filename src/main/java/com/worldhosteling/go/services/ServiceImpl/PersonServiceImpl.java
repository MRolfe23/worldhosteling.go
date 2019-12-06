package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Person;
import com.worldhosteling.go.repositories.PersonRepository;
import com.worldhosteling.go.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ############ THIS SERVICE IS NOT MEANT TO BE UTILIZED BY FRONTEND ############### //
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public Optional<Person> findPersonById(String id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public List<Person> savePersonList(List<Person> personList0) {
        return null;
    }

}
