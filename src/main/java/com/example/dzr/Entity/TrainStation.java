package com.example.dzr.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trainId;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    private Long stationId;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    private LocalDateTime predictTimeArrival;

    private LocalDateTime predictTimeDeparture;

    private LocalDateTime TimeArrival;

    private LocalDateTime TimeDeparture;
}
