package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.dto.CommentDto;
import com.good.fly.trip_planner.exception.NotFoundExceptions;
import com.good.fly.trip_planner.model.Comment;
import com.good.fly.trip_planner.model.OriginalPlace;
import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.CommentRepository;
import com.good.fly.trip_planner.repository.OriginalPlaceRepository;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private OriginalPlaceRepository originalPlaceRepository;

    @Override
    public String addComment(CommentDto commentDto) {

        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());

        Optional<User> optionalUser = userRepository.findById(commentDto.getUserId());
        User user = optionalUser.orElseThrow(NotFoundExceptions::new);

        Optional<OriginalPlace> optionalOriginalPlace = originalPlaceRepository.findById(commentDto.getOriginalPlaceId());
        OriginalPlace originalPlace = optionalOriginalPlace.orElseThrow(NotFoundExceptions::new);

        comment.setOriginalPlace(originalPlace);
        comment.setUser(user);
        Comment comment1 = commentRepository.save(comment);

        return "Comment " + comment1.getId() + " added!";
    }

    @Override
    public String deleteComment(Long commentId) {

        commentRepository.deleteById(commentId);

        return "Comment " + commentId + " deleted!";
    }
}
