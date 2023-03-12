package com.example.dzr.DTO.Station;

import lombok.Data;

@Data
public class StationDTO {

    private Long id;

    private Long countLines;

    private String name;

    private String country;

    private String city;

    private String street;

    private String building;
}
