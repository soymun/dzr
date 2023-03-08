package com.example.dzr.DTO.Train;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrainDto {

    private Long id;

    private String name;

    private Boolean repeatable;

    private String description;
}
