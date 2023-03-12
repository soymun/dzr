package com.example.dzr.Repository;

import com.example.dzr.Entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {

    List<TrainStation> getTrainStationsByTrainId(Long id);
}
