package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.AddPersonTicketDTO;
import com.example.dzr.DTO.CreateTicketDTO;
import com.example.dzr.Entity.Trains.Place;
import com.example.dzr.Entity.Trains.Train;
import com.example.dzr.Entity.Users.Person;
import com.example.dzr.Entity.Users.Ticket;
import com.example.dzr.Entity.Users.User;
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
    public Ticket addTicket(CreateTicketDTO createTicketDTO) {
        Ticket ticket = new Ticket();
        Train train = trainRepository.findTrainById(createTicketDTO.getTrainId());
        Place place = placeRepository.findPlaceById(createTicketDTO.getPlaceId());
        ticket.setPlace(place);
        ticket.setTrain(train);
        ticket.setPrice(createTicketDTO.getPrice());
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public Ticket addPersonTicket(AddPersonTicketDTO addPersonTicketDTO) {
        Ticket ticket = ticketRepository.findTicketById(addPersonTicketDTO.getTicketId());
        Person person = personRepository.findPersonById(addPersonTicketDTO.getPersonId());
        User user = userRepository.findUserById(addPersonTicketDTO.getUserId());

        ticket.setPerson(person);
        ticket.setDateBuy(new Date());

        user.getTickets().add(ticket);
        userRepository.save(user);
        return ticket;
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
