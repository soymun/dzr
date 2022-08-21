package com.example.dzr.Entity.Trains;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long place;

    @ManyToOne
    @JoinColumn(name = "carriageId")
    private Carriage carriage;

    private boolean busy;
}
