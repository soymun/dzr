package com.example.dzr.Controllers;


import com.example.dzr.DTO.AddCarriage;
import com.example.dzr.DTO.FromToTrainDTO;
import com.example.dzr.DTO.StationDTO;
import com.example.dzr.DTO.TrainDTO;
import com.example.dzr.Service.IMP.TrainServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {

    private final TrainServiceImp trainServiceImp;

    @Autowired
    public TrainController(TrainServiceImp trainServiceImp) {
        this.trainServiceImp = trainServiceImp;
    }

    @PostMapping("/train/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addTrain(@RequestBody TrainDTO trainDTO){
        return ResponseEntity.ok(trainServiceImp.saveTrain(trainDTO));
    }

    @GetMapping("/train/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getTrainById(@PathVariable Long id){
        return ResponseEntity.ok(trainServiceImp.getTrainById(id));
    }

    @GetMapping("/train/get/from/to")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getTrainFromTo(@RequestBody FromToTrainDTO fromToTrainDTO){
        return ResponseEntity.ok(trainServiceImp.getTrainFromTo(fromToTrainDTO));
    }

    @PostMapping("/train/add/carriage/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addCarriage(@PathVariable Long id, @RequestBody List<AddCarriage> addCarriage){
        return ResponseEntity.ok(trainServiceImp.addCarriageInTrain(id, addCarriage));
    }

    @PostMapping("/train/add/statison/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> addStation(@PathVariable Long id, @RequestBody List<StationDTO> stationDTOS){
        return ResponseEntity.ok(trainServiceImp.addStation(id, stationDTOS));
    }
}
