package com.example.dzr.DTO.Carriage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarriageDto {

    private Long id;

    private Long number;

    private Long countPlace;

    private Long trainId;
}
