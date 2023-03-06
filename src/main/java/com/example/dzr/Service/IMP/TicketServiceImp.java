package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.AddPersonTicketDTO;
import com.example.dzr.Entity.Person;
import com.example.dzr.Entity.Ticket;
import com.example.dzr.Entity.User;
import com.example.dzr.Repository.*;
import com.example.dzr.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImp implements TicketService {

    private final PlaceRepository placeRepository;

    private final TrainRepository trainRepository;

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final PersonRepository personRepository;


    @Autowired
    public TicketServiceImp(PlaceRepository placeRepository, TrainRepository trainRepository, UserRepository userRepository, TicketRepository ticketRepository, PersonRepository personRepository) {
        this.placeRepository = placeRepository;
        this.trainRepository = trainRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.personRepository = personRepository;
    }
    @Override
    public Ticket addPersonTicket(AddPersonTicketDTO addPersonTicketDTO) {
        return null;
    }

    @Override
    public void deletePersonTicket(Long id) {
        Ticket ticket = ticketRepository.findTicketById(id);
        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> getTicketByTrainId(Long id) {
        return ticketRepository.findAllByTrainId(id);
    }
}
