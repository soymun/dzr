package com.example.dzr.Entity.Users;

import com.example.dzr.Entity.Trains.Place;
import com.example.dzr.Entity.Trains.Train;
import com.example.dzr.Entity.Users.Person;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateBuy;

    @OneToOne
    @JoinColumn(name ="tiketId")
    private Place place;

    private Long price;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;
}
