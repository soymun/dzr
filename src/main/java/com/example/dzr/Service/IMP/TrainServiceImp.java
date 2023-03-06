package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Train.TrainCreateDto;
import com.example.dzr.DTO.Train.TrainDto;
import com.example.dzr.DTO.Train.TrainUpdateDto;
import com.example.dzr.Repository.TrainRepository;
import com.example.dzr.Service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainServiceImp implements TrainService {

    private final TrainRepository trainRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TrainDto saveTrain(TrainCreateDto trainDTO) {
        return null;
    }

    @Override
    public TrainDto updateTrain(TrainUpdateDto trainUpdateDto) {
        return null;
    }

    @Override
    public void deleteTrain(Long id) {

    }

    @Override
    public List<TrainDto> getTrainByDayAndFromTo(LocalDateTime day, String from, String to) {
        return null;
    }

    @Override
    public List<TrainDto> getTrainByStationAndDay(Long stationId, LocalDateTime day) {
        return null;
    }
}
