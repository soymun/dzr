package com.example.dzr.DTO;

import com.example.dzr.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

    private Long id;

    private Boolean activating;

    private String uuid;

    private String email;

    private String password;

    private Role role;
}
