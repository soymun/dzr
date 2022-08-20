package com.example.dzr.Entity.Trains;

import com.example.dzr.Entity.Trains.Carriage;

import javax.persistence.*;
import java.util.List;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainId")
    private List<Carriage> carriages;

    @ManyToMany
    @JoinTable(name = "trainStation", joinColumns = @JoinColumn(name = "trainId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "stationId", referencedColumnName = "id"))
    private List<Station> stations;
}
