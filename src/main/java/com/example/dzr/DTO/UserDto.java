package com.example.dzr.DTO;

import com.example.dzr.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private Role role;

    private String uuid;

    private Boolean activating;
}
