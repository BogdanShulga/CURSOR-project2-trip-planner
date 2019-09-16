package com.good.fly.trip_planner.service;

import com.good.fly.trip_planner.model.User;

public interface UserService {

    String addUser(User user);

    User getUser(Long userId);

    String deleteUser(Long userId);
}
