package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.Train.TrainCreateDto;
import com.example.dzr.DTO.Train.TrainDto;
import com.example.dzr.DTO.Train.TrainUpdateDto;
import com.example.dzr.Entity.*;
import com.example.dzr.Entity.Station_;
import com.example.dzr.Entity.TrainStation_;
import com.example.dzr.Entity.Train_;
import com.example.dzr.Exception.NotFoundException;
import com.example.dzr.Mapper.TrainMapper;
import com.example.dzr.Repository.TrainRepository;
import com.example.dzr.Service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainServiceImp implements TrainService {

    private final TrainRepository trainRepository;

    private final TrainMapper trainMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTrain(TrainCreateDto trainDTO) {
        log.info("Сохранение поезда");
        trainRepository.save(trainMapper.trainCreateDtoToTrain(trainDTO));

    }

    @Override
    public TrainDto updateTrain(TrainUpdateDto trainUpdateDto) {
        log.info("Изменение поезда с id {}", trainUpdateDto.getId());
        Train train = trainRepository.findById(trainUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException(String.format("Поезд с id %d не найден",trainUpdateDto.getId()));
        });
        if(trainUpdateDto.getName() != null){
            train.setName(trainUpdateDto.getName());
        }
        if(trainUpdateDto.getDescription() != null){
            train.setDescription(trainUpdateDto.getName());
        }
        if(trainUpdateDto.getRepeatable() != null){
            train.setRepeatable(trainUpdateDto.getRepeatable());
        }
        return trainMapper.trainToTrainDto(trainRepository.save(train));
    }

    @Override
    public void deleteTrain(Long id) {
        log.info("Удалнеие поезда с id {}", id);
        trainRepository.deleteById(id);
    }

    @Override
    public List<TrainDto> getTrainByDayAndFromTo(LocalDateTime day, String from, String to) {
        log.info("Выдача поездов с отъездом в определённый день и по станциям");
        LocalDateTime localDateTime = day.plusHours(23);
        localDateTime = localDateTime.plusMinutes(59);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrainDto> cq = cb.createQuery(TrainDto.class);
        Root<TrainStation> root = cq.from(TrainStation.class);
        Join<TrainStation, Station> join = root.join(TrainStation_.STATION);
        Join<TrainStation, Train> join1 = root.join(TrainStation_.TRAIN);


        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<TrainStation> root1 = subquery.from(TrainStation.class);
        Join<TrainStation, Station> join2 = root1.join(TrainStation_.STATION);

        subquery.where(cb.and(cb.equal(join2.get(Station_.NAME), to),
                cb.equal(root1.get(TrainStation_.TRAIN_ID), root.get(TrainStation_.TRAIN_ID))));

        subquery.select(root1.get(TrainStation_.id));

        cq.where(cb.and(cb.equal(join.get(Station_.NAME), from),
                cb.lessThanOrEqualTo(root.get(TrainStation_.predictTimeDeparture), localDateTime),
                cb.greaterThanOrEqualTo(root.get(TrainStation_.predictTimeDeparture), day),
                cb.isNotNull(subquery)
        ));

        cq.multiselect(
                join1.get(Train_.id),
                join1.get(Train_.name),
                join1.get(Train_.repeatable),
                join1.get(Train_.description)
        );
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<TrainDto> getTrainByStationAndDay(Long stationId, LocalDateTime day) {
        log.info("Выдача поездов на данной станции в один день");
        LocalDateTime localDateTime = day.plusHours(23);
        localDateTime = localDateTime.plusMinutes(59);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrainDto> cq = cb.createQuery(TrainDto.class);
        Root<TrainStation> root = cq.from(TrainStation.class);
        Join<TrainStation, Train> join1 = root.join(TrainStation_.TRAIN);

        cq.where(cb.and(cb.equal(root.get(TrainStation_.stationId), stationId),
                cb.lessThanOrEqualTo(root.get(TrainStation_.predictTimeDeparture), localDateTime),
                cb.greaterThanOrEqualTo(root.get(TrainStation_.predictTimeDeparture), day)
        ));

        cq.multiselect(
                join1.get(Train_.id),
                join1.get(Train_.name),
                join1.get(Train_.repeatable),
                join1.get(Train_.description)
        );
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public TrainDto getTrainById(Long id) {
        log.info("Выдача поезда по id {}", id);
        Train train = trainRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("Поезд с id %d не найден",id));
        });
        return trainMapper.trainToTrainDto(train);
    }
}
