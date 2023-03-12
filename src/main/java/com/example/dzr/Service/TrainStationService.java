package com.example.dzr.Service;

import com.example.dzr.DTO.TrainStation.TrainStationCreateDto;
import com.example.dzr.DTO.TrainStation.TrainStationGetDto;
import com.example.dzr.DTO.TrainStation.TrainStationUpdateDto;
import com.example.dzr.Entity.TrainStation;

import java.util.List;

public interface TrainStationService {

    void saveTrainStation(TrainStationCreateDto trainStationCreateDto);

    void deleteTrainStation(Long id);

    TrainStationGetDto updateTrainStation(TrainStationUpdateDto trainStationUpdateDto);

    List<TrainStationGetDto> getStationByTrain(Long id);
}
