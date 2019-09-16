package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.ShareTripDto;
import com.good.fly.trip_planner.dto.TripDepartureDto;
import com.good.fly.trip_planner.model.Trip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TripService {
    ResponseEntity<Trip> createTrip(Long userId);

    ResponseEntity<Boolean> deleteTrip(Long tripId);

    ResponseEntity<String> setShareStatus(ShareTripDto shareTripDto);

    ResponseEntity<String> setDepartureDate(TripDepartureDto tripDepartureDto);

    ResponseEntity<List<Trip>> getAllTrips(Long userId);

    ResponseEntity<String> addPlaceToTrip(Long originalPlaceId, Long tripId);

    ResponseEntity<String> deletePlaceInTrip(Long placeId, Long tripId);
}