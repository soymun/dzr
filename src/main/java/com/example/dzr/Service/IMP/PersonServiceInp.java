package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Person.PersonCreateDto;
import com.example.dzr.DTO.Person.PersonDto;
import com.example.dzr.DTO.Person.PersonUpdateDto;
import com.example.dzr.Entity.Person;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.PersonMapper;
import com.example.dzr.Repository.PersonRepository;
import com.example.dzr.Service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceInp implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonDto updatePerson(PersonUpdateDto updatePersonDTO) {
        log.info("Изменение пасажира с id {}", updatePersonDTO.getId());
        Person person = personRepository.findById(updatePersonDTO.getId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Пассажир с id %d не найден",updatePersonDTO.getId()));
        });
        if(updatePersonDTO.getName() != null){
            person.setName(updatePersonDTO.getName());
        }
        if(updatePersonDTO.getSurname() != null){
            person.setSurname(updatePersonDTO.getSurname());
        }
        if(updatePersonDTO.getPatronymic() != null){
            person.setPatronymic(updatePersonDTO.getPatronymic());
        }
        if(updatePersonDTO.getNumberPassport() != null){
            person.setNumberPassport(updatePersonDTO.getNumberPassport());
        }
        if(updatePersonDTO.getSeriesPassport() != null){
            person.setSeriesPassport(updatePersonDTO.getSeriesPassport());
        }
        if(updatePersonDTO.getBirthday() != null){
            person.setBirthday(updatePersonDTO.getBirthday());
        }
        if(updatePersonDTO.getBalls() != null){
            person.setBalls(updatePersonDTO.getBalls());
        }
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    @Override
    public void savePerson(PersonCreateDto personCreateDto) {
        log.info("Сохранение пасажира у пользователя с id {}", personCreateDto.getUserId());
        Person person = personMapper.personCreateDtoToPerson(personCreateDto);
        person.setBalls(0L);
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        log.info("Удаление пасажира с id {}", id);
        personRepository.deleteById(id);
    }

    @Override
    public List<PersonDto> getPersonByUserId(Long id) {
        log.info("Выдача пасажиров у пользователя с id {}", id);
        return personRepository.getPersonByUserId(id)
                .stream()
                .map(personMapper::personToPersonDto)
                .toList();
    }

    @Override
    public PersonDto getPersonById(Long id) {
        log.info("Выдача пассажира с id {}", id);
        return personMapper.personToPersonDto(personRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Пассажир с id %d не найден",id));
        }));
    }
}
