package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> addUser(User user);

    ResponseEntity<User> getUser(Long userId);

    ResponseEntity<String> deleteUser(Long userId);
}
