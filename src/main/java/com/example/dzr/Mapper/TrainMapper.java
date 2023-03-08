package com.example.dzr.Mapper;

import com.example.dzr.DTO.Train.TrainCreateDto;
import com.example.dzr.DTO.Train.TrainDto;
import com.example.dzr.Entity.Train;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainMapper {

    Train trainCreateDtoToTrain(TrainCreateDto trainCreateDto);

    TrainDto trainToTrainDto(Train train);
}
