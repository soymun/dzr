package com.example.dzr.DTO;


import lombok.Data;

@Data
public class AddPersonTicketDTO {

    private Long userId;

    private Long personId;

    private Long ticketId;
}
