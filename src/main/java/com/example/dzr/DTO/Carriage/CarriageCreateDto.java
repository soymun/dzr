package com.example.dzr.DTO.Carriage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarriageCreateDto {

    private Long number;

    private Long countPlace;

    private Long trainId;

    private Long price;
}
