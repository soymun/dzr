package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.*;
import com.example.dzr.Entity.*;
import com.example.dzr.Repository.TrainRepository;
import com.example.dzr.Service.TrainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class TrainServiceImp implements TrainService {

    private final TrainRepository trainRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public TrainServiceImp(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Transactional
    @Override
    public Train getTrainById(Long id) {
        return trainRepository.findTrainById(id);
    }

    @Override
    public List<TrainGetDTO> getTrainFromTo(FromToTrainDTO fromToTrainDTO) {
        return null;
    }

    @Override
    public Train saveTrain(TrainDTO trainDTO) {
        Train train = new Train();
        train.setName(trainDTO.getName());
        trainRepository.save(train);
        return train;
    }

    @Override
    public Train addCarriageInTrain(Long id, List<AddCarriage> addCarriages) {
        Train train = trainRepository.findTrainById(id);
        return train;
    }

    @Override
    public Train addStation(Long id,List<StationDTO> stationDTO) {
        Train train = trainRepository.findTrainById(id);
        return train;
    }
}
