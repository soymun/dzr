package com.example.dzr.Repository;

import com.example.dzr.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findTrainById(Long id);

}
