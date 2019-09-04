package com.good.fly.trip_planner.repository;

import com.good.fly.trip_planner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
