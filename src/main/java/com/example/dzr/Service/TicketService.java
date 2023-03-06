package com.example.dzr.Service;

import com.example.dzr.DTO.AddPersonTicketDTO;
import com.example.dzr.Entity.Ticket;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {


    @Transactional
    Ticket addPersonTicket(AddPersonTicketDTO addPersonTicketDTO);

    @Transactional
    void deletePersonTicket(Long id);

    @Transactional
    List<Ticket> getTicketByTrainId(Long id);
}
