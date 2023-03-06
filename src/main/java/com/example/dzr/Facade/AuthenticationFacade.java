package com.example.dzr.Facade;

import com.example.dzr.DTO.LoginDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.DTO.UserDto;
import com.example.dzr.Exception.FoundException;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Jwt.JwtTokenProvider;
import com.example.dzr.Service.IMP.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserServiceImp userServiceImp;


    public ResponseEntity<?> registrationUser(RegistrationDTO registrationDTO){
        UserDto user = userServiceImp.getUserByEmail(registrationDTO.getEmail());
        if(user == null){
            return ResponseEntity.ok(userServiceImp.save(registrationDTO));
        }
        throw new FoundException(String.format("Пользователь с email %s уже существует", registrationDTO.getEmail()));
    }

    public ResponseEntity<?> login(LoginDTO loginDTO){
        try{
            UserDto user = userServiceImp.getUserByEmail(loginDTO.getEmail());
            if(user == null){
                throw new AuthenticationException(
                        String.format("Пользователь с email %s уже существует", loginDTO.getEmail())
                );
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());
            Map<Object, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("role", user.getRole().getAuthority());
            map.put("token", token);
            return ResponseEntity.ok(map);
        } catch (AuthenticationException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
