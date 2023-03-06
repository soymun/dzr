package com.example.dzr.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long place;

    private Long price;

    private boolean busy;

    @Column(name = "carriage_id")
    private Long carriageId;

    @ManyToOne
    @JoinColumn(name = "carriage_id")
    private Carriage carriage;
}
