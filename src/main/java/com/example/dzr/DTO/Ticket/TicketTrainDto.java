package com.example.dzr.DTO.Ticket;

import com.example.dzr.DTO.Person.PersonDto;
import com.example.dzr.DTO.Place.PlaceDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketTrainDto {

    private Long id;

    private LocalDateTime dateBuy;

    private PlaceDto place;

    private PersonDto person;
}
