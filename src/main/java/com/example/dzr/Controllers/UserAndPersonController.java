package com.example.dzr.Controllers;

import com.example.dzr.DTO.CreatePersonDTO;
import com.example.dzr.DTO.UpdatePersonDTO;
import com.example.dzr.Service.IMP.PersonServiceInp;
import com.example.dzr.Service.IMP.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAndPersonController {

    private final UserServiceImp userServiceImp;

    private final PersonServiceInp personServiceInp;

    @Autowired
    public UserAndPersonController(UserServiceImp userServiceImp, PersonServiceInp personServiceInp) {
        this.userServiceImp = userServiceImp;
        this.personServiceInp = personServiceInp;
    }

    @PostMapping("/person/create")
    @PreAuthorize("hasAuthority('Commuter')")
    public ResponseEntity<?> addPerson(CreatePersonDTO createPersonDTO){
        return null;
    }

    @GetMapping("/ticket/user/get/all/{id}")
    @PreAuthorize("hasAuthority('Commuter')")
    public ResponseEntity<?> getTicketList(@PathVariable Long id){
        return null;
    }

    @GetMapping("/person/user/get/all/{id}")
    @PreAuthorize("hasAuthority('Commuter')")
    public ResponseEntity<?> getAllPerson(@PathVariable Long id){
        return null;
    }

    @PostMapping("/person/update")
    @PreAuthorize("hasAuthority('Commuter')")
    public ResponseEntity<?> updatePerson(@RequestBody UpdatePersonDTO updatePersonDTO){
        return null;
    }
}
