package com.example.dzr.Service;

import com.example.dzr.DTO.CreatePersonDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.DTO.UserDto;
import com.example.dzr.DTO.UserUpdateDto;
import com.example.dzr.Entity.Person;
import com.example.dzr.Entity.Ticket;
import com.example.dzr.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String save(RegistrationDTO registrationDTO);

    UserDto getUserByEmail(String email);

    UserDto getUserById(Long id);

    UserDto updateUser(UserUpdateDto userUpdateDto);

    void deleteUser(Long id);

    void activateUser(String uuid);
}
