package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.dto.ShareTripDto;
import com.good.fly.trip_planner.dto.TripDepartureDto;
import com.good.fly.trip_planner.model.Trip;
import com.good.fly.trip_planner.service.TripService;
import lombok.AllArgsConstructor;
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
        return tripService.createTrip(userId);
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity<Boolean> deleteTrip(@PathVariable Long tripId) {
        return tripService.deleteTrip(tripId);
    }

    @PutMapping("/share")
    public ResponseEntity<String> setShareStatus(@RequestBody ShareTripDto shareTripDto) {
        return tripService.setShareStatus(shareTripDto);
    }

    @PutMapping("/departure")
    public ResponseEntity<String> setDepartureDate(@RequestBody TripDepartureDto tripDepartureDto) {
        return tripService.setDepartureDate(tripDepartureDto);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Trip>> getAllTrips(@PathVariable Long userId) {
        return tripService.getAllTrips(userId);
    }

    @PostMapping("/place")
    public ResponseEntity<String> addPlaceToTrip(@RequestParam Long originalPlaceId, @RequestParam Long tripId) {
        return tripService.addPlaceToTrip(originalPlaceId, tripId);
    }

    @DeleteMapping("/place")
    public ResponseEntity<String> deletePlaceInTrip(@RequestParam Long placeId, @RequestParam Long tripId) {
        return tripService.deletePlaceInTrip(placeId, tripId);
    }
}
