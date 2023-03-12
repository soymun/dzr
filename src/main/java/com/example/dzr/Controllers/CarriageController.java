package com.example.dzr.Controllers;


import com.example.dzr.DTO.Carriage.CarriageCreateDto;
import com.example.dzr.Service.IMP.CarriageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarriageController {

    private final CarriageServiceImpl carriageService;

    @PostMapping("/carriage")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveCarriage(@RequestBody CarriageCreateDto carriageCreateDto){
        carriageService.create(carriageCreateDto);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/carriage/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        carriageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/train/carriage/{id}")
    public ResponseEntity<?> getPlaceByCarriageId(@PathVariable Long id){
        return ResponseEntity.ok(carriageService.getCarriageByTrainId(id));
    }
}
