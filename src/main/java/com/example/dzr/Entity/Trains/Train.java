package com.example.dzr.Entity.Trains;

import com.example.dzr.Entity.Trains.Carriage;
import com.example.dzr.Entity.Users.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainId")
    private List<Carriage> carriages;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "trainStation", joinColumns = @JoinColumn(name = "trainId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "stationId", referencedColumnName = "id"))
    private List<Station> stations;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
