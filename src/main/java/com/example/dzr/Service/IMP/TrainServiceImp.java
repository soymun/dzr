package com.example.dzr.Service.IMP;

import com.example.dzr.DTO.*;
import com.example.dzr.Entity.Trains.*;
import com.example.dzr.Entity.Users.Ticket;
import com.example.dzr.Repository.StationRepository;
import com.example.dzr.Repository.TrainRepository;
import com.example.dzr.Service.TrainService;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrainGetDTO> cq = cb.createQuery(TrainGetDTO.class);
        Root<Train> root = cq.from(Train.class);
        Join<Train, Station> join = root.join(Train_.stations);
        cq.where(cb.or(cb.equal(join.get(Station_.name), fromToTrainDTO.getFrom()),cb.equal(join.get(Station_.name), fromToTrainDTO.getTo())));
        cq.groupBy(root.get(Train_.id));
        cq.having(cb.equal(cb.count(root.get(Train_.name)), 2));
        cq.multiselect(
                root.get(Train_.id),
                root.get(Train_.name)
        );
        return entityManager.createQuery(cq).getResultList();
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
        for(AddCarriage carriage: addCarriages){
            Carriage carriage1 = new Carriage();
            carriage1.setNumber(carriage.getNumber());
            for (long i = 1; i<= carriage.getCountPlace();i++){
                Place place = new Place();
                place.setPlace(i);
                Ticket ticket = new Ticket();
                ticket.setTrain(train);
                ticket.setPlace(place);
                ticket.setPrice(carriage.getPrice());
                train.getTickets().add(ticket);
                carriage1.getPlaces().add(place);
            }
            train.getCarriages().add(carriage1);
        }
        trainRepository.save(train);
        return train;
    }

    @Override
    public Train addStation(Long id,List<StationDTO> stationDTO) {
        Train train = trainRepository.findTrainById(id);
        for(StationDTO station: stationDTO){
            Station station1 = new Station();
            station1.setName(station.getName());
            train.getStations().add(station1);
        }
        trainRepository.save(train);
        return train;
    }
}
