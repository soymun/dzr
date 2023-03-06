package com.example.dzr.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateBuy;

    @Column(name = "place_id")
    private Long placeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="place_Id", insertable = false, updatable = false)
    private Place place;

    @Column(name = "person_id")
    private Long personId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
