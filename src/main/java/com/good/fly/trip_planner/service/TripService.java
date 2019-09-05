package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.ShareTrip;
import com.good.fly.trip_planner.dto.TripIdDepartureDate;
import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.model.Trip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TripService {
    ResponseEntity<Trip> createTrip(Long userId);

    ResponseEntity<Boolean> deleteTrip(Long tripId);

    ResponseEntity<String> setShareStatus(ShareTrip shareTrip);

    ResponseEntity<String> setDepartureDate(TripIdDepartureDate tripIdDepartureDate);

    ResponseEntity<List<Trip>> getAllTrips(Long userId);

    ResponseEntity<String> addPlaceToTrip(Long originalPlaceId, Long tripId);

    ResponseEntity<String> deletePlaceInTrip(Long placeId, Long tripId);
}