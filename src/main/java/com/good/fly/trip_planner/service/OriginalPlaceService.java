package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.model.OriginalPlace;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OriginalPlaceService {
    ResponseEntity<List<OriginalPlace>> getAllOriginalPlacesWithComments();
}
