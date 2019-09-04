package com.good.fly.trip_planner.repository;

import com.good.fly.trip_planner.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
