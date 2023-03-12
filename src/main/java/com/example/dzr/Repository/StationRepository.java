package com.example.dzr.Repository;

import com.example.dzr.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> getStationsByCity(String city);
}
