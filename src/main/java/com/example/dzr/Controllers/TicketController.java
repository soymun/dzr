package com.example.dzr.Controllers;

import com.example.dzr.DTO.Ticket.TicketCreateDto;
import com.example.dzr.Service.IMP.TicketServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketServiceImp ticketServiceImp;

    @PostMapping("/ticket")
    public ResponseEntity<?> saveTicket(@RequestBody TicketCreateDto ticketCreateDto){
        ticketServiceImp.saveTicket(ticketCreateDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/train/ticket/{id}")
    @PreAuthorize("hasAuthority('Guide')")
    public ResponseEntity<?> getAllTicketByTrainId(@PathVariable Long id){
        return ResponseEntity.ok(ticketServiceImp.getTicketByTrainId(id));
    }

    @GetMapping("/user/ticket/{id}")
    public ResponseEntity<?> getTicketByUserId(@PathVariable Long id){
        return ResponseEntity.ok(ticketServiceImp.getTicketByUserId(id));
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id){
        ticketServiceImp.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
