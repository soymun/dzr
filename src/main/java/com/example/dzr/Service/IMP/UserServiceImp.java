package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.RegistrationDTO;
import com.example.dzr.DTO.UserDto;
import com.example.dzr.DTO.UserUpdateDto;
import com.example.dzr.Entity.Role;
import com.example.dzr.Entity.User;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.UserMapper;
import com.example.dzr.Repository.UserRepository;
import com.example.dzr.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new NotFoundException(String.format("Пользователь с email %s не найден", username));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.getRole().getAuthority()
        );
    }

    @Override
    public String save(RegistrationDTO registrationDTO) {
        log.info("Сохранение пользователя");
        User user = new User();
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setRole(Role.USER);
        user.setActivating(false);
        user.setUuid(UUID.randomUUID().toString());
        userRepository.save(user);
        return user.getUuid();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        log.info("Выдача пользователя по email {}", email);
        return userMapper.userToUserDto(userRepository.findUserByEmail(email));
    }

    @Override
    public UserDto getUserById(Long id) {
        log.info("Выдача пользователя по id {}", id);
        return userMapper.userToUserDto(userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Пользователь с id %d не найден",id));
        }));
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(userUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Пользователь с id %d не найден",userUpdateDto.getId()));
        });
        if (userUpdateDto.getEmail() != null) {
            user.setEmail(userUpdateDto.getEmail());
        }
        if (userUpdateDto.getPassword() != null) {
            user.setPassword(userUpdateDto.getPassword());
        }
        if (userUpdateDto.getRole() != null) {
            user.setRole(userUpdateDto.getRole());
        }
        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Удаление пользователя с id {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public void activateUser(String uuid) {
        log.info("Активация пользователя по uuid");
        User user = userRepository.getUserByUuid(uuid).orElseThrow(() -> {
            throw new NotFoundException(String.format("Пользователь с uuid %s не найден",uuid));
        });
        user.setActivating(true);
        user.setUuid(null);
        userRepository.save(user);
    }
}
