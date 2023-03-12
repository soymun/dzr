package com.example.dzr.DTO.Place;

import lombok.Data;

@Data
public class PlaceDto {

    private Long id;

    private Long place;

    private Long price;

    private boolean busy;

    private Long carriageId;

    private Long numberCarriage;

    private Long trainId;

    private String numberTrain;
}
