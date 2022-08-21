package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.UpdatePersonDTO;
import com.example.dzr.Entity.Users.Person;
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
        Person person = personRepository.findPersonById(updatePersonDTO.getId());
        if(updatePersonDTO.getName() != null){
            person.setName(updatePersonDTO.getName());
        }
        if(updatePersonDTO.getSurname() != null){
            person.setSurname(updatePersonDTO.getSurname());
        }
        if(updatePersonDTO.getPatronym() != null){
            person.setPatronym(updatePersonDTO.getPatronym());
        }
        if(updatePersonDTO.getPasport() != null){
            person.setPasport(updatePersonDTO.getPasport());
        }
        if(updatePersonDTO.getBirthday() != null){
            person.setBirthday(updatePersonDTO.getBirthday());
        }
        if(updatePersonDTO.getCart() != null){
            person.setCart(updatePersonDTO.getCart());
        }
        return person;
    }
}
