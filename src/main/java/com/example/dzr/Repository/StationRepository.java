package com.example.dzr.Repository;

import com.example.dzr.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

    Station findStationById(Long id);
}
