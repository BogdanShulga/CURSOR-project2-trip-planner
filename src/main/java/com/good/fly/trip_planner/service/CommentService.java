package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.CommentPlaceIdUserId;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<String> addComment(CommentPlaceIdUserId commentPlaceIdUserId);

    ResponseEntity<String> deleteComment(Long commentId);
}