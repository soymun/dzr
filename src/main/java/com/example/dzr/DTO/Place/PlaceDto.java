package com.example.dzr.DTO.Place;

import com.example.dzr.Entity.Carriage;
import lombok.Data;

import javax.persistence.*;

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
