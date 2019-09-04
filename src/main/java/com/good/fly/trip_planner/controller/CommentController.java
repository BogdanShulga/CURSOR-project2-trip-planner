package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.dto.CommentPlaceIdUserId;
import com.good.fly.trip_planner.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping("/add/comment")
    public ResponseEntity<String> addComment(@RequestBody CommentPlaceIdUserId commentPlaceIdUserId) {
        return commentService.addComment(commentPlaceIdUserId);
    }

    @DeleteMapping("/delete/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
}
