package com.example.dzr.Mapper;

import com.example.dzr.DTO.Place.PlaceDto;
import com.example.dzr.Entity.Carriage;
import com.example.dzr.Entity.Place;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    static PlaceDto map(Place value){
        PlaceDto placeDto = new PlaceDto();
        if(value == null){
            return placeDto;
        }
        placeDto.setId(value.getId());
        placeDto.setPlace(value.getPlace());
        placeDto.setBusy(value.isBusy());
        placeDto.setPrice(value.getPrice());
        placeDto.setCarriageId(value.getCarriageId());
        Carriage carriage = value.getCarriage();
        placeDto.setNumberCarriage(carriage.getNumber());
        placeDto.setNumberTrain(carriage.getTrain().getName());
        placeDto.setTrainId(carriage.getTrainId());
        return placeDto;
    }
}
