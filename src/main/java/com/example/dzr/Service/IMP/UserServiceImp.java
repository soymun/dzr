package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.CreatePersonDTO;
import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.Entity.Users.Person;
import com.example.dzr.Entity.Users.Ticket;
import com.example.dzr.Entity.Users.User;
import com.example.dzr.Repository.UserRepository;
import com.example.dzr.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRole().getAuthority());
    }

    @Transactional
    @Override
    public User saveUser(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(registrationDTO.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public Person createPerson(CreatePersonDTO createPersonDTO) {
        User user = userRepository.findUserById(createPersonDTO.getUserId());
        Person person = new Person();
        person.setName(createPersonDTO.getName());
        person.setSurname(createPersonDTO.getSurname());
        person.setPatronym(createPersonDTO.getPatronym());
        person.setBirthday(createPersonDTO.getBirthday());
        person.setPasport(createPersonDTO.getPasport());
        user.getPeople().add(person);
        userRepository.save(user);
        return person;
    }

    @Transactional
    @Override
    public List<Ticket> getAllUserTicket(Long id) {
        User user = userRepository.findUserById(id);
        return user.getTickets();
    }

    @Transactional
    @Override
    public List<Person> getAllUserPerson(Long id) {
        User user = userRepository.findUserById(id);
        return user.getPeople();
    }
}
