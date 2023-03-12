package com.example.dzr.Controllers;

import com.example.dzr.DTO.Station.StationCreateDto;
import com.example.dzr.Service.IMP.StationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationServiceImpl stationService;

    @PostMapping("/station")
    public ResponseEntity<?> saveTicket(@RequestBody StationCreateDto stationCreateDto){
        stationService.saveStation(stationCreateDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/station/{id}")
    public ResponseEntity<?> getAllTicketByTrainId(@PathVariable Long id){
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @GetMapping("/station")
    public ResponseEntity<?> getStationByCity(@RequestParam String city){
        return ResponseEntity.ok(stationService.getStationByCity(city));
    }

    @DeleteMapping("/station/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id){
        stationService.getStationById(id);
        return ResponseEntity.noContent().build();
    }
}
