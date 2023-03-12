package com.example.dzr.Controllers;


import com.example.dzr.DTO.Security.LoginDTO;
import com.example.dzr.DTO.Security.RegistrationDTO;
import com.example.dzr.Facade.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/rzd")
public class AuthenticationController {

    private final AuthenticationFacade authenticationFacade;

    @PostMapping("/registration")
    public ResponseEntity<?> registrationUser(@RequestBody RegistrationDTO registrationDTO){
        return authenticationFacade.registrationUser(registrationDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return authenticationFacade.login(loginDTO);
    }
}
