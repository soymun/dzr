package com.example.dzr.Repository;

import com.example.dzr.Entity.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {

    List<Carriage> getCarriagesByTrainId(Long id);
}
