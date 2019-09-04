package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.model.Place;
import com.good.fly.trip_planner.repository.PlaceRepository;
import com.good.fly.trip_planner.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    @Override
    public ResponseEntity<List<Place>> getAllPlacesWithComments() {
        List<Place> places = placeRepository.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(places);
    }
}
