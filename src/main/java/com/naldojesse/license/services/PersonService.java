package com.naldojesse.license.services;

import com.naldojesse.license.models.Person;
import com.naldojesse.license.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> findPersonById(Long id) {
        return personRepository.findById(id);
    }

}
