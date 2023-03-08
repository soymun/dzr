package com.example.dzr.DTO.Train;

import lombok.Data;

@Data
public class TrainUpdateDto {

    private Long id;

    private String name;

    private Boolean repeatable;

    private String description;
}
