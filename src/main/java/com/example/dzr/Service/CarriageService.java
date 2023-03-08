package com.example.dzr.Service;

import com.example.dzr.DTO.Carriage.CarriageCreateDto;
import com.example.dzr.DTO.Carriage.CarriageDto;

import java.util.List;

public interface CarriageService {

    void create(CarriageCreateDto carriageCreateDto);

    List<CarriageDto> getCarriageByTrainId(Long trainId);

    void deleteById(Long id);
}
