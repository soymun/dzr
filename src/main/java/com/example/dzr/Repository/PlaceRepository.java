package com.example.dzr.Repository;

import com.example.dzr.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findPlaceById(Long id);
}
