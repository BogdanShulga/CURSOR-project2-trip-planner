package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.exception.NotFoundExceptions;
import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public String addUser(User user) {

        userRepository.save(user);

        return "User " + user.getFirstName() + " " + user.getLastName() + " is added!";
    }

    @Override
    public User getUser(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.orElseThrow(NotFoundExceptions::new);
    }

    @Override
    public String deleteUser(Long userId) {

        userRepository.deleteById(userId);

        return "User with id " + userId + " is deleted!";
    }
}
