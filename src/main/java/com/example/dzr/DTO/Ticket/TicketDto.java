package com.example.dzr.DTO.Ticket;

import com.example.dzr.DTO.Place.PlaceDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {

    private Long id;

    private LocalDateTime dateBuy;

    private PlaceDto place;

    private Long personId;
}
