package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Station.StationCreateDto;
import com.example.dzr.DTO.Station.StationDTO;
import com.example.dzr.DTO.Station.StationUpdateDto;
import com.example.dzr.Entity.Station;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.StationMapper;
import com.example.dzr.Repository.StationRepository;
import com.example.dzr.Service.StationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    private final StationMapper stationMapper;

    @Override
    public void saveStation(StationCreateDto stationCreateDto) {
        log.info("Сохранение станции");
        stationRepository.save(stationMapper.stationCreateDtoToStation(stationCreateDto));
    }

    @Override
    public StationDTO getStationById(Long id) {
        log.info("Выдача станции по id {}", id);
        return stationMapper.stationToStationDto(stationRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Станция с id %d не найдена", id));
        }));
    }

    @Override
    public void deleteStationById(Long id) {
        log.info("Удаление станции с id {}", id);
        stationRepository.deleteById(id);
    }

    @Override
    public List<StationDTO> getStationByCity(String city) {
        log.info("Выдача станций по городу");
        return stationRepository.getStationsByCity(city).stream().map(stationMapper::stationToStationDto).toList();
    }

    @Override
    public StationDTO updateStation(StationUpdateDto stationUpdateDto) {
        log.info("Изменение станций с id {}", stationUpdateDto.getId());
        Station station = stationRepository.findById(stationUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Станция с id %d не найдена", stationUpdateDto.getId()));
        });
        if(stationUpdateDto.getCountLines() != null){
            station.setCountLines(stationUpdateDto.getCountLines());
        }
        if(stationUpdateDto.getName() != null){
            station.setName(stationUpdateDto.getName());
        }
        if(stationUpdateDto.getCountry() != null){
            station.setCountry(stationUpdateDto.getCountry());
        }
        if(stationUpdateDto.getCity() != null){
            station.setCity(stationUpdateDto.getCity());
        }
        if(stationUpdateDto.getStreet() != null){
            station.setStreet(stationUpdateDto.getStreet());
        }
        if(stationUpdateDto.getBuilding() != null){
            station.setBuilding(stationUpdateDto.getBuilding());
        }
        return stationMapper.stationToStationDto(stationRepository.save(station));
    }
}
