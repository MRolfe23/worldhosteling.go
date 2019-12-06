package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}
