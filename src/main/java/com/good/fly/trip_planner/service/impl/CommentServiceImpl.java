package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.dto.CommentPlaceIdUserId;
import com.good.fly.trip_planner.model.Comment;
import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.CommentRepository;
import com.good.fly.trip_planner.repository.OriginalPlaceRepository;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private OriginalPlaceRepository originalPlaceRepository;

    @Override
    public ResponseEntity<String> addComment(CommentPlaceIdUserId commentPlaceIdUserId) {
        Comment comment = new Comment();
        comment.setComment(commentPlaceIdUserId.getComment());
        User user = new User();
        Optional<User> optionalUser = userRepository.findById(commentPlaceIdUserId.getUserId());
        if (optionalUser.isPresent()) user = optionalUser.get();
        OriginalPlace originalPlace = new OriginalPlace();
        Optional<OriginalPlace> optionalOriginalPlace = originalPlaceRepository.findById(commentPlaceIdUserId.getOriginalPlaceId());
        if (optionalOriginalPlace.isPresent()) originalPlace = optionalOriginalPlace.get();
        comment.setOriginal_place(originalPlace);
        comment.setUser(user);
        Comment comment1 = commentRepository.save(comment);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Comment " + comment1.getId() + " added!");
    }

    @Override
    public ResponseEntity<String> deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Comment " + commentId + " deleted!");
    }
}
