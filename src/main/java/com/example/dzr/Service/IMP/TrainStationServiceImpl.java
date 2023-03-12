package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.TrainStation.TrainStationCreateDto;
import com.example.dzr.DTO.TrainStation.TrainStationGetDto;
import com.example.dzr.DTO.TrainStation.TrainStationUpdateDto;
import com.example.dzr.Entity.TrainStation;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.TrainStationMapper;
import com.example.dzr.Repository.TrainStationRepository;
import com.example.dzr.Service.TrainStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainStationServiceImpl implements TrainStationService {

    private final TrainStationMapper trainStationMapper;

    private final TrainStationRepository trainStationRepository;

    @Override
    public void saveTrainStation(TrainStationCreateDto trainStationCreateDto) {
        log.info("Сохранение станции поезда");
        trainStationRepository.save(trainStationMapper.trainStationCreateDtoToTrainStation(trainStationCreateDto));
    }

    @Override
    public void deleteTrainStation(Long id) {
        log.info("Удаление станции поезда с id {}", id);
        trainStationRepository.deleteById(id);
    }

    @Override
    public TrainStationGetDto updateTrainStation(TrainStationUpdateDto trainStationUpdateDto) {
        log.info("Изменение станции пользователя по id {}", trainStationUpdateDto.getId());
        TrainStation trainStation = trainStationRepository.findById(trainStationUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Станция поезда с id" + trainStationUpdateDto.getId() + "не найденна");
        });
        if (trainStationUpdateDto.getPredictTimeArrival() != null) {
            trainStation.setPredictTimeArrival(trainStationUpdateDto.getPredictTimeArrival());
        }
        if (trainStationUpdateDto.getPredictTimeDeparture() != null) {
            trainStation.setPredictTimeDeparture(trainStationUpdateDto.getPredictTimeDeparture());
        }
        if (trainStationUpdateDto.getTimeArrival() != null) {
            trainStation.setTimeArrival(trainStationUpdateDto.getTimeArrival());
        }
        if (trainStationUpdateDto.getTimeDeparture() != null) {
            trainStation.setTimeDeparture(trainStationUpdateDto.getTimeDeparture());
        }
        return trainStationMapper.trainStationToTrainStationGetDto(trainStationRepository.save(trainStation));
    }

    @Override
    public List<TrainStationGetDto> getStationByTrain(Long id) {
        log.info("Выдача станци по поезду с id {}", id);
        return trainStationRepository.getTrainStationsByTrainId(id)
                .stream()
                .map(trainStationMapper::trainStationToTrainStationGetDto)
                .toList();
    }
}
