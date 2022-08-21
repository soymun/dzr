package com.example.dzr.DTO;

import lombok.Data;


@Data
public class CreateTicketDTO {

    private Long placeId;

    private Long price;

    private Long trainId;
}
