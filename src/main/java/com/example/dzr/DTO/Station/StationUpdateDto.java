package com.example.dzr.DTO.Station;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StationUpdateDto {

    private Long id;

    private Long countLines;

    private String name;

    private String country;

    private String city;

    private String street;

    private String building;
}
