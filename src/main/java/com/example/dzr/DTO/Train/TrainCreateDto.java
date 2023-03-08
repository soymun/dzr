package com.example.dzr.DTO.Train;

import lombok.Data;

@Data
public class TrainCreateDto {

    private String name;

    private Boolean repeatable;

    private String description;
}
