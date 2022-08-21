package com.example.dzr.Service;

import com.example.dzr.DTO.UpdatePersonDTO;
import com.example.dzr.Entity.Users.Person;
import com.example.dzr.Entity.Users.Ticket;
import org.springframework.transaction.annotation.Transactional;

public interface PersonService {
    @Transactional
    Person updatePerson(UpdatePersonDTO updatePersonDTO);
}
