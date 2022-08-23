package com.example.dzr.Controllers;


import com.example.dzr.DTO.LoginDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.Entity.Users.Role;
import com.example.dzr.Entity.Users.User;
import com.example.dzr.Jwt.JwtTokenProvider;
import com.example.dzr.Service.IMP.UserServiceImp;
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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserServiceImp userServiceImp;

    @Autowired
    public AuthenticationController(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserServiceImp userServiceImp) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registrationUser(@RequestBody RegistrationDTO registrationDTO){
        User user = userServiceImp.getUserByEmail(registrationDTO.getEmail());
        if(user == null){
            return ResponseEntity.ok(userServiceImp.saveUser(registrationDTO));
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try{
            User user = userServiceImp.getUserByEmail(loginDTO.getEmail());
            if(user == null){
                throw new AuthenticationException("user not found");
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());
            Map<Object, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("role", user.getRole().getAuthority());
            map.put("token", token);
            return ResponseEntity.ok(map);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/logout")
    @PreAuthorize("hasAuthority('Commuter')")
    public void logout(HttpServletRequest request, HttpServletResponse response,@RequestBody LoginDTO loginDTO){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
    }

    @PostMapping("/registration/guide")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User registrationGuide(@RequestBody LoginDTO loginDTO){
        User user = userServiceImp.getUserByEmail(loginDTO.getEmail());
        user.setRole(Role.Conductor);
        return userServiceImp.saveGuideUser(user);
    }
}
