package com.example.dzr.Mapper;

import com.example.dzr.DTO.TrainStation.TrainStationCreateDto;
import com.example.dzr.DTO.TrainStation.TrainStationGetDto;
import com.example.dzr.Entity.TrainStation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainStationMapper {

    TrainStation trainStationCreateDtoToTrainStation(TrainStationCreateDto trainStationCreateDto);

    TrainStationGetDto trainStationToTrainStationGetDto(TrainStation trainStation);
}
