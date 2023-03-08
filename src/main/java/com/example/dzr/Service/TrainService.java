package com.example.dzr.Service;

import com.example.dzr.DTO.*;
import com.example.dzr.DTO.Train.TrainCreateDto;
import com.example.dzr.DTO.Train.TrainDto;
import com.example.dzr.DTO.Train.TrainUpdateDto;
import com.example.dzr.Entity.Train;

import java.time.LocalDateTime;
import java.util.List;

public interface TrainService {

    void saveTrain(TrainCreateDto trainDTO);

    TrainDto updateTrain(TrainUpdateDto trainUpdateDto);

    void deleteTrain(Long id);

    List<TrainDto> getTrainByDayAndFromTo(LocalDateTime day, String from, String to);

    List<TrainDto> getTrainByStationAndDay(Long stationId, LocalDateTime day);


}
