package com.example.dzr.DTO.Person;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonDto {

    private Long id;

    private Long userId;

    private String name;

    private String surname;

    private String patronymic;

    private Integer number_passport;

    private Integer series_passport;

    private LocalDateTime birthday;

    private Long balls;
}
