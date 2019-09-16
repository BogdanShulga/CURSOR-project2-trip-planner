package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {

        String answer = userService.addUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(answer);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {

        User user = userService.getUser(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {

        String answer = userService.deleteUser(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answer);
    }
}
