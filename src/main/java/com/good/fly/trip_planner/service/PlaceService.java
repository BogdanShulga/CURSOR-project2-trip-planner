package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.model.Place;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaceService {
    ResponseEntity<List<Place>> getAllPlacesWithComments();
}