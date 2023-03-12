package com.example.dzr.Controllers;


import com.example.dzr.DTO.Station.StationCreateDto;
import com.example.dzr.DTO.TrainStation.TrainStationCreateDto;
import com.example.dzr.DTO.TrainStation.TrainStationUpdateDto;
import com.example.dzr.Service.IMP.TrainStationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TrainStationController {

    private final TrainStationServiceImpl trainStationService;

    @PostMapping("/train/station")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveTicket(@RequestBody TrainStationCreateDto trainStationCreateDto){
        trainStationService.saveTrainStation(trainStationCreateDto);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/train/station")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateTrainStation(@RequestBody TrainStationUpdateDto trainStationUpdateDto){
        return ResponseEntity.ok(trainStationService.updateTrainStation(trainStationUpdateDto));
    }

    @GetMapping("/train/station/{id}")
    public ResponseEntity<?> getTrainStationByTrain(@PathVariable Long id){
        return ResponseEntity.ok(trainStationService.getStationByTrain(id));
    }

    @DeleteMapping("/train/station/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteTrainStation(@PathVariable Long id){
        trainStationService.deleteTrainStation(id);
        return ResponseEntity.noContent().build();
    }
}
