package com.example.dzr.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dateBuy;

    @Column(name = "place_id")
    private Long placeId;

    @Fetch(value = FetchMode.JOIN)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="place_Id", insertable = false, updatable = false)
    private Place place;

    @Column(name = "person_id")
    private Long personId;

    @ManyToOne
    @Fetch(value = FetchMode.JOIN)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @Column(name = "train_id")
    private Long trainId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", insertable = false, updatable = false)
    private Train train;
}
