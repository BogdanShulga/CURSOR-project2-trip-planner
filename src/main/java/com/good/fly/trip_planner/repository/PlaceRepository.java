package com.good.fly.trip_planner.repository;

import com.good.fly.trip_planner.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
