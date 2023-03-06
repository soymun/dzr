package com.example.dzr.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    private Long countPlace;

    @Column(name = "train_id")
    private Long trainId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", insertable = false, updatable = false)
    private Train train;
}
