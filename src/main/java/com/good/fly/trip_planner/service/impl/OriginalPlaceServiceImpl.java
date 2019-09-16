package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.repository.OriginalPlaceRepository;
import com.good.fly.trip_planner.service.OriginalPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OriginalPlaceServiceImpl implements OriginalPlaceService {

    private OriginalPlaceRepository originalPlaceRepository;

    @Override
    public List<OriginalPlace> getAllOriginalPlacesWithComments() {

        return originalPlaceRepository.findAll();
    }
}
