package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Place.PlaceDto;
import com.example.dzr.Entity.Carriage;
import com.example.dzr.Entity.Place;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.PlaceMapper;
import com.example.dzr.Repository.CarriageRepository;
import com.example.dzr.Repository.PlaceRepository;
import com.example.dzr.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    private final CarriageRepository carriageRepository;


    @Override
    @Transactional
    public void deletePlace(Long id) {
        log.info("Удаление места с id {}", id);
        Place place = placeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Место с id %d не найден",id));
        });
        Carriage carriage = place.getCarriage();
        carriage.setCountPlace(carriage.getCountPlace()+1);
        placeRepository.deleteById(id);
        carriageRepository.save(carriage);
    }

    @Override
    public List<PlaceDto> getPlaceByCarriageId(Long id) {
        return placeRepository.getPlacesByCarriageId(id).stream().map(PlaceMapper::map).toList();
    }
}
