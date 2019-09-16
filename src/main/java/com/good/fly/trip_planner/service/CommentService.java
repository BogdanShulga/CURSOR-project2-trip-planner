package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.CommentDto;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<String> addComment(CommentDto commentDto);

    ResponseEntity<String> deleteComment(Long commentId);
}