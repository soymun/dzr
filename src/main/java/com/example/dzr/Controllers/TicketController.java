package com.example.dzr.Controllers;

import com.example.dzr.DTO.AddPersonTicketDTO;
import com.example.dzr.Service.IMP.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    private final TicketServiceImp ticketServiceImp;

    @Autowired
    public TicketController(TicketServiceImp ticketServiceImp) {
        this.ticketServiceImp = ticketServiceImp;
    }

    @PostMapping("/person/ticket")
    @PreAuthorize("hasAuthority('Commuter')")
    public ResponseEntity<?> addPersonTicket(AddPersonTicketDTO addPersonTicketDTO){
        return ResponseEntity.ok(ticketServiceImp.addPersonTicket(addPersonTicketDTO));
    }

    @GetMapping("/ticket/get/all/{id}")
    @PreAuthorize("hasAuthority('Guide')")
    public ResponseEntity<?> getAllTicketByTrainId(@PathVariable Long id){
        return ResponseEntity.ok(ticketServiceImp.getTicketByTrainId(id));
    }

    @DeleteMapping("/ticket/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteTicket(@PathVariable Long id){
        ticketServiceImp.deletePersonTicket(id);
    }
}
