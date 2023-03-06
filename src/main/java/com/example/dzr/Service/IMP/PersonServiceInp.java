package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.UpdatePersonDTO;
import com.example.dzr.Entity.Person;
import com.example.dzr.Repository.PersonRepository;
import com.example.dzr.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceInp implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceInp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person updatePerson(UpdatePersonDTO updatePersonDTO) {
        return null;
    }
}
