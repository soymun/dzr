package com.example.dzr.Controllers;


import com.example.dzr.DTO.LoginDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.DTO.UserDto;
import com.example.dzr.Entity.Role;
import com.example.dzr.Entity.User;
import com.example.dzr.Facade.AuthenticationFacade;
import com.example.dzr.Jwt.JwtTokenProvider;
import com.example.dzr.Service.IMP.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
