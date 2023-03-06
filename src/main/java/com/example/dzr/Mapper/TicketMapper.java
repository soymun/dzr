package com.example.dzr.Mapper;

import com.example.dzr.DTO.Place.PlaceDto;
import com.example.dzr.DTO.Ticket.TicketCreateDto;
import com.example.dzr.DTO.Ticket.TicketDto;
import com.example.dzr.DTO.Ticket.TicketTrainDto;
import com.example.dzr.Entity.Carriage;
import com.example.dzr.Entity.Place;
import com.example.dzr.Entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket ticketCreateDtoToTicket(TicketCreateDto ticketCreateDto);

    TicketDto ticketToTicketDto(Ticket ticket);

    TicketTrainDto ticketToTicketTrainDto(Ticket ticket);

    default PlaceDto map(Place value){
        PlaceDto placeDto = new PlaceDto();
        if(value == null){
            return placeDto;
        }
        placeDto.setId(value.getId());
        placeDto.setPlace(value.getPlace());
        placeDto.setBusy(value.isBusy());
        placeDto.setPrice(value.getPrice());
        placeDto.setCarriageId(value.getCarriageId());
        Carriage carriage = value.getCarriage();
        placeDto.setNumberCarriage(carriage.getNumber());
        placeDto.setNumberTrain(carriage.getTrain().getName());
        placeDto.setTrainId(carriage.getTrainId());
        return placeDto;
    }
}
