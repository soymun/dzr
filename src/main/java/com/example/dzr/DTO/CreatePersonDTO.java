package com.example.dzr.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CreatePersonDTO {

    private Long userId;

    private String name;

    private String surname;

    private String patronym;

    private String pasport;

    private Date birthday;
}
