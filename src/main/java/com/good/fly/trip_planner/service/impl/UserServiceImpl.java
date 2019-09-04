package com.good.fly.trip_planner.service.impl;

import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.repository.UserRepository;
import com.good.fly.trip_planner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> addUser(User user) {
        userRepository.save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User " + user.getFirstName() + " " + user.getLastName() + " is added!");
    }

    @Override
    public ResponseEntity<User> getUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = new User();
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User with id " + userId + " is deleted!");
    }
}
