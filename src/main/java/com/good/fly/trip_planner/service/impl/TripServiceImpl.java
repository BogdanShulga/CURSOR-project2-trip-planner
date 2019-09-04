package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.dto.ShareTrip;
import com.good.fly.trip_planner.dto.TripIdDepartureDate;
import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.model.Trip;
import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.PlaceRepository;
import com.good.fly.trip_planner.repository.TripRepository;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {

    private PlaceRepository placeRepository;
    private TripRepository tripRepository;
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Trip> createTrip(Long userId) {
        Trip trip = new Trip();
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(trip::setUser);
        trip.setName("Wonder");
        Trip trip1 = tripRepository.save(trip);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trip1);
    }

    @Override
    public ResponseEntity<Boolean> deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(true);
    }

    @Override
    public ResponseEntity<String> setShareStatus(ShareTrip shareTrip) {
        Optional<Trip> optionalTrip = tripRepository.findById(shareTrip.getTripId());
        Trip trip = new Trip();
        if (optionalTrip.isPresent()) {
            trip = optionalTrip.get();
            trip.setShared(shareTrip.isShare());
            tripRepository.save(trip);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Trip " + trip.getName() + " " + (shareTrip.isShare() ? "is shared!" : "is hidden!"));
    }

    @Override
    public ResponseEntity<String> setDepartureDate(TripIdDepartureDate tripIdDepartureDate) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripIdDepartureDate.getTripId());
        Trip trip = new Trip();
        if (optionalTrip.isPresent()) {
            trip = optionalTrip.get();
            trip.setDepartureDate(tripIdDepartureDate.getDepartureDate());
            tripRepository.save(trip);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Departure date to the trip " + trip.getName() + " is set!");

    }

    @Override
    public ResponseEntity<List<Trip>> getAllTrips(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        List<Trip> trips = new ArrayList<>();
        if (optionalUser.isPresent()) {
            trips = optionalUser.get().getTrips();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trips);
    }

    @Override
    public ResponseEntity<String> addPlaceToTrip(Place place, Long tripId) {
        Trip trip = tripRepository.getOne(tripId);
        trip.getPlaces().add(place);
        tripRepository.save(trip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Place " + place.getName() + " added to trip " + trip.getName() + "!");
    }

    @Override
    public ResponseEntity<String> deletePlaceInTrip(Long placeId, Long tripId) {
        Trip trip = tripRepository.getOne(tripId);
        Place place = placeRepository.getOne(placeId);
        boolean remove = trip.getPlaces().remove(place);
        tripRepository.save(trip);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Place " + place.getName() + (remove ? "removed!" : "not removed!"));
    }
}
