package com.example.dzr.Controllers;


import com.example.dzr.Service.IMP.PlaceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceServiceImpl placeService;

    @GetMapping("/carriage/place/{id}")
    public ResponseEntity<?> getPlaceByCarriageId(@PathVariable Long id){
        return ResponseEntity.ok(placeService.getPlaceByCarriageId(id));
    }

    @DeleteMapping("/place/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}
