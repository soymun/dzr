package com.example.dzr.Repository;

import com.example.dzr.Entity.Users.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findTicketById(Long id);

    List<Ticket> findAllByTrainId(Long id);
}
