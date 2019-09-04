package com.good.fly.trip_planner.controller;

import com.good.fly.trip_planner.model.User;
import com.good.fly.trip_planner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/add/user")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/get/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/delete/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
