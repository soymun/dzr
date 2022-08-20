package com.example.dzr.Entity.Trains;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "carriageId")
    private List<Place> places;
}
