package com.good.fly.trip_planner.repository;

import com.good.fly.trip_planner.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
