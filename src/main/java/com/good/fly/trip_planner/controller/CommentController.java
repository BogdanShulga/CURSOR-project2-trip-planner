package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.dto.CommentDto;
import com.good.fly.trip_planner.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
}
