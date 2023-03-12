package com.example.dzr.Repository;

import com.example.dzr.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> getPlacesByCarriageId(Long id);
}
