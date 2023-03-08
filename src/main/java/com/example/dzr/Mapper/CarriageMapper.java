package com.example.dzr.Mapper;

import com.example.dzr.DTO.Carriage.CarriageCreateDto;
import com.example.dzr.DTO.Carriage.CarriageDto;
import com.example.dzr.Entity.Carriage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarriageMapper {

    CarriageDto carriageToCarriageDto(Carriage carriage);

    Carriage carriageCreateDtoToCarriage(CarriageCreateDto carriageCreateDto);
}
