package com.example.dzr.DTO.Person;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonUpdateDto {

    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    private Integer numberPassport;

    private Integer seriesPassport;

    private LocalDateTime birthday;

    private Long balls;
}
