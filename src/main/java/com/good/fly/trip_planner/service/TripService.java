package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.ShareTripDto;
import com.good.fly.trip_planner.dto.TripDepartureDto;
import com.good.fly.trip_planner.model.Trip;

import java.util.List;

public interface TripService {

    Trip createTrip(Long userId);

    Boolean deleteTrip(Long tripId);

    String setShareStatus(ShareTripDto shareTripDto);

    String setDepartureDate(TripDepartureDto tripDepartureDto);

    List<Trip> getAllTrips(Long userId);

    String addPlaceToTrip(Long originalPlaceId, Long tripId);

    String deletePlaceInTrip(Long placeId, Long tripId);
}