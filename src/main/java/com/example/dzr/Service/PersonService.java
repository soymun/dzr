package com.example.dzr.Service;

import com.example.dzr.DTO.Person.PersonCreateDto;
import com.example.dzr.DTO.Person.PersonDto;
import com.example.dzr.DTO.Person.PersonUpdateDto;

import java.util.List;

public interface PersonService {

    PersonDto updatePerson(PersonUpdateDto updatePersonDTO);

    void savePerson(PersonCreateDto personCreateDto);

    void deletePerson(Long id);

    List<PersonDto> getPersonByUserId(Long id);

    PersonDto getPersonById(Long id);
}
