package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.dto.ShareTrip;
import com.good.fly.trip_planner.dto.TripIdDepartureDate;
import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.model.Trip;
import com.good.fly.trip_planner.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TripController {

    private TripService tripService;

    @GetMapping("/create/trip/{userId}")
    public ResponseEntity<Trip> createTrip(@PathVariable Long userId) {
        return tripService.createTrip(userId);
    }

    @DeleteMapping("delete/trip/{tripId}")
    public ResponseEntity<Boolean> deleteTrip(@PathVariable Long tripId) {
        return tripService.deleteTrip(tripId);
    }

    @PutMapping("/share")
    public ResponseEntity<String> setShareStatus(@RequestBody ShareTrip shareTrip) {
        return tripService.setShareStatus(shareTrip);
    }

    @PutMapping("/departure")
    public ResponseEntity<String> setDepartureDate(@RequestBody TripIdDepartureDate tripIdDepartureDate) {
        return tripService.setDepartureDate(tripIdDepartureDate);
    }

    @GetMapping("/get/all/trips/{userId}")
    public ResponseEntity<List<Trip>> getAllTrips(@PathVariable Long userId) {
        return tripService.getAllTrips(userId);
    }

    @PostMapping("/add/place/to/trip/{tripId}")
    public ResponseEntity<String> addPlaceToTrip(@RequestBody Place place, @PathVariable Long tripId) {
        return tripService.addPlaceToTrip(place, tripId);
    }

    @DeleteMapping("/delete/place/in/trip")
    public ResponseEntity<String> deletePlaceInTrip(@RequestParam Long placeId, @RequestParam Long tripId) {
        return tripService.deletePlaceInTrip(placeId, tripId);
    }
}
