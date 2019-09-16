package com.good.fly.trip_planner.dto;

import lombok.Data;

@Data
public class CommentDto {

    private String comment;

    private Long originalPlaceId;

    private Long userId;
}
