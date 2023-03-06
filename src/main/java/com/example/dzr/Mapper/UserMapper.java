package com.example.dzr.Mapper;

import com.example.dzr.DTO.UserDto;
import com.example.dzr.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
}
