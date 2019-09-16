package com.good.fly.trip_planner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TripDepartureDto {

    private Long tripId;

    LocalDate departureDate;
}
