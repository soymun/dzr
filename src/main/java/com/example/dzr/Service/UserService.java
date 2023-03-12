package com.example.dzr.Service;

import com.example.dzr.DTO.Security.RegistrationDTO;
import com.example.dzr.DTO.User.UserDto;
import com.example.dzr.DTO.User.UserUpdateDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    String save(RegistrationDTO registrationDTO);

    UserDto getUserByEmail(String email);

    UserDto getUserById(Long id);

    UserDto updateUser(UserUpdateDto userUpdateDto);

    void deleteUser(Long id);

    void activateUser(String uuid);
}
