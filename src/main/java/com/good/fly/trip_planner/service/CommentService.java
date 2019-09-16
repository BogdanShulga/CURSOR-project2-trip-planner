package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.dto.CommentDto;

public interface CommentService {

    String addComment(CommentDto commentDto);

    String deleteComment(Long commentId);
}