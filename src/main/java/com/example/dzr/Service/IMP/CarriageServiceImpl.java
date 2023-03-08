package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Carriage.CarriageCreateDto;
import com.example.dzr.DTO.Carriage.CarriageDto;
import com.example.dzr.Entity.Carriage;
import com.example.dzr.Entity.Place;
import com.example.dzr.Mapper.CarriageMapper;
import com.example.dzr.Repository.CarriageRepository;
import com.example.dzr.Repository.PlaceRepository;
import com.example.dzr.Service.CarriageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.BatchSize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarriageServiceImpl implements CarriageService {

    private final CarriageRepository carriageRepository;

    private final PlaceRepository placeRepository;

    private final CarriageMapper carriageMapper;

    @Override
    @Transactional
    @BatchSize(size = 30)
    public void create(CarriageCreateDto carriageCreateDto) {
        log.info("Сохранение вагона");
        Carriage carriage = carriageMapper.carriageCreateDtoToCarriage(carriageCreateDto);
        carriage = carriageRepository.save(carriage);
        for (int i = 1; i <= carriage.getCountPlace(); i++){
            Place place = new Place();
            place.setPlace((long) i);
            place.setPrice(carriageCreateDto.getPrice());
            place.setCarriageId(carriage.getId());
            placeRepository.save(place);
        }
    }

    @Override
    public List<CarriageDto> getCarriageByTrainId(Long trainId) {
        log.info("Выдача вагонов по поезду с id {}", trainId);
        return carriageRepository.getCarriagesByTrainId(trainId).stream().map(carriageMapper::carriageToCarriageDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        log.info("Удаление вагона по id {}", id);
        carriageRepository.deleteById(id);
    }
}
