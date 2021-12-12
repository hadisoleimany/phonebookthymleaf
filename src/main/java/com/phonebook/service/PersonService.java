package com.phonebook.service;

import com.phonebook.model.Person;
import com.phonebook.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    public List<Person> getListPerson(){
        return repository.findAll();
    }


    public Person getById(Long id){
        Person person = repository.getById(id);
        if(person==null)
            throw new RuntimeException("Not Found Exception");
        return person;
    }
    public void save(Person person){
        repository.save(person);
    }

    public void deletePerson(Long personId){
        repository.deleteById(personId);
    }
}
