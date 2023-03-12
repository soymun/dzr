package com.example.dzr.Service;

import com.example.dzr.DTO.Station.StationCreateDto;
import com.example.dzr.DTO.Station.StationDTO;
import com.example.dzr.DTO.Station.StationUpdateDto;

import java.util.List;

public interface StationService {

    void saveStation(StationCreateDto stationCreateDto);

    StationDTO getStationById(Long id);

    void deleteStationById(Long id);

    List<StationDTO> getStationByCity(String city);

    StationDTO updateStation(StationUpdateDto stationUpdateDto);
}
