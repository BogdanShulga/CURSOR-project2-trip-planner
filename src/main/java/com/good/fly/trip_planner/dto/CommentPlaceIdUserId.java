package com.good.fly.trip_planner.dto;

import lombok.Data;

@Data
public class CommentPlaceIdUserId {
    private String comment;
    private Long originalPlaceId;
    private Long userId;
}
