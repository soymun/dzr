package com.example.dzr.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_id")
    private Long trainId;

    @ManyToOne
    @JoinColumn(name = "train_id", insertable = false, updatable = false)
    private Train train;

    @Column(name = "station_id")
    private Long stationId;

    @ManyToOne
    @JoinColumn(name = "station_id", insertable = false, updatable = false)
    private Station station;

    private LocalDateTime predictTimeArrival;

    private LocalDateTime predictTimeDeparture;

    private LocalDateTime TimeArrival;

    private LocalDateTime TimeDeparture;
}
