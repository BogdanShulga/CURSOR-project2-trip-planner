package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlaceController {

    private PlaceService placeService;

    @GetMapping("/get/all/places")
    public ResponseEntity<List<Place>> getAllPlacesWithComments() {
        return placeService.getAllPlacesWithComments();
    }

}
