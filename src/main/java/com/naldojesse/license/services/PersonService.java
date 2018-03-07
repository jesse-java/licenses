package com.naldojesse.license.services;

import com.naldojesse.license.models.Person;
import com.naldojesse.license.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

//    public void addPerson(String first_name, String last_name) {
//        personRepository.save();
//    }
//
//    public Optional<Person> findPersonById(Long id) {
//        return personRepository.findById(id);
//    }

}
