package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.service.OriginalPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/place")
public class OriginalPlaceController {

    private OriginalPlaceService originalPlaceService;

    @GetMapping("/all")
    public ResponseEntity<List<OriginalPlace>> getAllPlaces() {

        List<OriginalPlace> originalPlaces = originalPlaceService.getAllOriginalPlacesWithComments();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(originalPlaces);
    }

}
