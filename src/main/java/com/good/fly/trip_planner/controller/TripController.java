package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.dto.ShareTripDto;
import com.good.fly.trip_planner.dto.TripDepartureDto;
import com.good.fly.trip_planner.model.Trip;
import com.good.fly.trip_planner.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/trip")
public class TripController {

    private TripService tripService;

    @PostMapping("/{userId}")
    public ResponseEntity<Trip> createTrip(@PathVariable Long userId) {

        Trip trip = tripService.createTrip(userId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trip);
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity<Boolean> deleteTrip(@PathVariable Long tripId) {

        boolean answer = tripService.deleteTrip(tripId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }

    @PutMapping("/share")
    public ResponseEntity<String> setShareStatus(@RequestBody ShareTripDto shareTripDto) {

        String answer = tripService.setShareStatus(shareTripDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }

    @PutMapping("/departure")
    public ResponseEntity<String> setDepartureDate(@RequestBody TripDepartureDto tripDepartureDto) {

        String answer = tripService.setDepartureDate(tripDepartureDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Trip>> getAllTrips(@PathVariable Long userId) {

        List<Trip> trips = tripService.getAllTrips(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trips);
    }

    @PostMapping("/place")
    public ResponseEntity<String> addPlaceToTrip(@RequestParam Long originalPlaceId, @RequestParam Long tripId) {

        String answer = tripService.addPlaceToTrip(originalPlaceId, tripId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }

    @DeleteMapping("/place")
    public ResponseEntity<String> deletePlaceInTrip(@RequestParam Long placeId, @RequestParam Long tripId) {

        String answer = tripService.deletePlaceInTrip(placeId, tripId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }
}
