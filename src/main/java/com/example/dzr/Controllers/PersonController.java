package com.example.dzr.Controllers;

import com.example.dzr.DTO.Person.PersonCreateDto;
import com.example.dzr.DTO.Person.PersonUpdateDto;
import com.example.dzr.Service.IMP.PersonServiceInp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceInp personServiceInp;

    @PostMapping("/person")
    public ResponseEntity<?> savePerson(@RequestBody  PersonCreateDto personCreateDto){
        personServiceInp.savePerson(personCreateDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/user/person/{id}")
    public ResponseEntity<?> getPersonByUserId(@PathVariable Long id){
        return ResponseEntity.ok(personServiceInp.getPersonByUserId(id));
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Long id){
        personServiceInp.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id){
        return ResponseEntity.ok(personServiceInp.getPersonById(id));
    }


    @PatchMapping ("/person")
    public ResponseEntity<?> updatePerson(@RequestBody PersonUpdateDto updatePersonDTO){
        return ResponseEntity.ok(personServiceInp.updatePerson(updatePersonDTO));
    }
}
