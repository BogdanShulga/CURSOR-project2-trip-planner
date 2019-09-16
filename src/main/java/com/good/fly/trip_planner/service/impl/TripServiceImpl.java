package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.dto.ShareTripDto;
import com.good.fly.trip_planner.dto.TripDepartureDto;
import com.good.fly.trip_planner.exception.NotFoundExceptions;
import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.model.Trip;
import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.OriginalPlaceRepository;
import com.good.fly.trip_planner.repository.PlaceRepository;
import com.good.fly.trip_planner.repository.TripRepository;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {

    private PlaceRepository placeRepository;
    private TripRepository tripRepository;
    private UserRepository userRepository;
    private OriginalPlaceRepository originalPlaceRepository;

    @Override
    public ResponseEntity<Trip> createTrip(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(NotFoundExceptions::new);

        Trip trip = new Trip();
        trip.setUser(user);
        trip.setName("Wonder " + trip.getUser().getFirstName() + "'s trip!");

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
    public ResponseEntity<String> setShareStatus(ShareTripDto shareTripDto) {

        Optional<Trip> optionalTrip = tripRepository.findById(shareTripDto.getTripId());
        Trip trip = optionalTrip.orElseThrow(NotFoundExceptions::new);

        trip.setShared(shareTripDto.isShare());
        tripRepository.save(trip);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Trip " + trip.getName() + " " + (shareTripDto.isShare() ? "is shared!" : "is hidden!"));
    }

    @Override
    public ResponseEntity<String> setDepartureDate(TripDepartureDto tripDepartureDto) {

        Optional<Trip> optionalTrip = tripRepository.findById(tripDepartureDto.getTripId());
        Trip trip = optionalTrip.orElseThrow(NotFoundExceptions::new);

        LocalDate departureDate = tripDepartureDto.getDepartureDate();

        int size;
        if (trip.getPlaces() != null) {
            size = trip.getPlaces().size();
        } else size = 0;

        LocalDate endDate = departureDate.plusDays(size == 0 ? 0 : size * 5);

        trip.setDepartureDate(departureDate);
        trip.setEndDate(endDate);
        tripRepository.save(trip);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Departure and end dates to the trip " + trip.getName() + " is set!");

    }

    @Override
    public ResponseEntity<List<Trip>> getAllTrips(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(NotFoundExceptions::new);

        List<Trip> trips = user.getTrips();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trips);
    }

    @Override
    public ResponseEntity<String> addPlaceToTrip(Long originalPlaceId, Long tripId) {

        Optional<OriginalPlace> optionalOriginalPlace = originalPlaceRepository.findById(originalPlaceId);
        OriginalPlace originalPlace = optionalOriginalPlace.orElseThrow(NotFoundExceptions::new);

        Trip trip = getTrip(tripId);

        Place place = new Place();
        place.setName(originalPlace.getName());
        place.setRating(originalPlace.getRating());
        place.setTrip(trip);

        trip.getPlaces().add(place);
        tripRepository.save(trip);

        if (trip.getDepartureDate() != null) {
            TripDepartureDto tripDepartureDto = getTripIdDepartureDate(trip);
            setDepartureDate(tripDepartureDto);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Place " + place.getName() + " added to trip " + trip.getName() + "!");
    }

    @Override
    public ResponseEntity<String> deletePlaceInTrip(Long placeId, Long tripId) {

        Trip trip = getTrip(tripId);

        Optional<Place> optionalPlace = placeRepository.findById(placeId);
        Place place = optionalPlace.orElseThrow(NotFoundExceptions::new);

        boolean remove = trip.getPlaces().remove(place);
        tripRepository.save(trip);

        if (trip.getDepartureDate() != null) {
            TripDepartureDto tripDepartureDto = getTripIdDepartureDate(trip);
            setDepartureDate(tripDepartureDto);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Place " + place.getName() + (remove ? "removed!" : "not removed!"));
    }

    private Trip getTrip(Long tripId) {

        Optional<Trip> optionalTrip = tripRepository.findById(tripId);

        return optionalTrip.orElseThrow(NotFoundExceptions::new);
    }

    private TripDepartureDto getTripIdDepartureDate(Trip trip) {
        TripDepartureDto tripDepartureDto = new TripDepartureDto();
        tripDepartureDto.setTripId(trip.getId());
        tripDepartureDto.setDepartureDate(trip.getDepartureDate());
        return tripDepartureDto;
    }
}
