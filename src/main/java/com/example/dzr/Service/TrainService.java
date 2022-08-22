package com.example.dzr.Service;

import com.example.dzr.DTO.*;
import com.example.dzr.Entity.Trains.Train;

import java.util.List;

public interface TrainService {

    Train getTrainById(Long id);

    List<TrainGetDTO> getTrainFromTo(FromToTrainDTO fromToTrainDTO);

    Train saveTrain(TrainDTO trainDTO);

    Train addCarriageInTrain(Long id, List<AddCarriage> addCarriages);

    Train addStation(Long id,List<StationDTO> stationDTO);
}
