package com.example.dzr.Mapper;

import com.example.dzr.DTO.Station.StationCreateDto;
import com.example.dzr.DTO.Station.StationDTO;
import com.example.dzr.Entity.Station;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationDTO stationToStationDto(Station station);

    Station stationCreateDtoToStation(StationCreateDto stationCreateDto);
}
