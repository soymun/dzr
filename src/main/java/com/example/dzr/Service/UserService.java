package com.example.dzr.Service;

import com.example.dzr.DTO.CreatePersonDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.Entity.Users.Person;
import com.example.dzr.Entity.Users.Ticket;
import com.example.dzr.Entity.Users.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUser(RegistrationDTO registrationDTO);

    Person createPerson(CreatePersonDTO createPersonDTO);

    List<Ticket> getAllUserTicket(Long id);

    List<Person> getAllUserPerson(Long id);

    User getUserByEmail(String email);

    User saveGuideUser(User user);
}
