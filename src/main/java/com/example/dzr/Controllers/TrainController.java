package com.example.dzr.Controllers;


import com.example.dzr.DTO.Train.FromToTrainDTO;
import com.example.dzr.DTO.Train.TrainCreateDto;
import com.example.dzr.DTO.Train.TrainsByStationDto;
import com.example.dzr.DTO.Train.TrainUpdateDto;
import com.example.dzr.Service.IMP.TrainServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TrainController {

    private final TrainServiceImp trainServiceImp;

    @PostMapping("/train")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveTrain(@RequestBody TrainCreateDto trainDTO){
        trainServiceImp.saveTrain(trainDTO);
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/train")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateTrain(@RequestBody TrainUpdateDto trainDTO){
        return ResponseEntity.ok(trainServiceImp.updateTrain(trainDTO));
    }

    @GetMapping("/train/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getTrainById(@PathVariable Long id){
        return ResponseEntity.ok(trainServiceImp.getTrainById(id));
    }

    @DeleteMapping("/train/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteTrain(@PathVariable Long id){
        trainServiceImp.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/train/to")
    public ResponseEntity<?> getTrainFromTo(@RequestBody FromToTrainDTO fromToTrainDTO) {
        return ResponseEntity.ok(trainServiceImp.getTrainByDayAndFromTo(fromToTrainDTO.getDay(), fromToTrainDTO.getFrom(), fromToTrainDTO.getTo()));
    }

    @GetMapping("/train/station")
    public ResponseEntity<?> getTrainFromTo(@RequestBody TrainsByStationDto fromToTrainDTO) {
        return ResponseEntity.ok(trainServiceImp.getTrainByStationAndDay(fromToTrainDTO.getStationId(), fromToTrainDTO.getDay()));
    }
}
