package com.example.dzr.Mapper;

import com.example.dzr.DTO.Person.PersonCreateDto;
import com.example.dzr.DTO.Person.PersonDto;
import com.example.dzr.Entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person personCreateDtoToPerson(PersonCreateDto personCreateDto);

    PersonDto personToPersonDto(Person person);
}
