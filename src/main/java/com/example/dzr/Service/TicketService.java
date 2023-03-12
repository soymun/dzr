package com.example.dzr.Service;

import com.example.dzr.DTO.Ticket.TicketCreateDto;
import com.example.dzr.DTO.Ticket.TicketDto;
import com.example.dzr.DTO.Ticket.TicketTrainDto;

import java.util.List;

public interface TicketService {


    TicketDto saveTicket(TicketCreateDto ticketCreateDto);

    void deleteTicket(Long id);

    List<TicketTrainDto> getTicketByTrainId(Long id);

    List<TicketDto> getTicketByUserId(Long id);
}
