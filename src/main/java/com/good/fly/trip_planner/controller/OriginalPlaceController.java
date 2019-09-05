package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.service.OriginalPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OriginalPlaceController {

    private OriginalPlaceService originalPlaceService;

    @GetMapping("/get/all/places")
    public ResponseEntity<List<OriginalPlace>> getAllPlaces() {
        return originalPlaceService.getAllOriginalPlacesWithComments();
    }

}
