package com.example.dzr.Service;

import com.example.dzr.DTO.Place.PlaceDto;

import java.util.List;

public interface PlaceService {

    void deletePlace(Long id);

    List<PlaceDto> getPlaceByCarriageId(Long id);
}
