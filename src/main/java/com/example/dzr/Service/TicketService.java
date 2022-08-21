package com.example.dzr.Service;

import com.example.dzr.DTO.AddPersonTicketDTO;
import com.example.dzr.DTO.CreateTicketDTO;
import com.example.dzr.Entity.Users.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {

    @Transactional
    Ticket addTicket(CreateTicketDTO createTicketDTO);

    @Transactional
    Ticket addPersonTicket(AddPersonTicketDTO addPersonTicketDTO);

    @Transactional
    void deletePersonTicket(Long id);

    @Transactional
    List<Ticket> getTicketByTrainId(Long id);
}
