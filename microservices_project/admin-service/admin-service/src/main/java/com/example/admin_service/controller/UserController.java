package com.example.admin_service.controller;

//package com.example.user_service.controller;

import com.example.admin_service.model.User;
import com.example.admin_service.model.UserTeam;
import com.example.admin_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/{userId}/team/{playerId}")
    public ResponseEntity<UserTeam> addPlayerToTeam(@PathVariable Long userId, @PathVariable Long playerId) {
        return ResponseEntity.ok(userService.addPlayerToTeam(userId, playerId));
    }

    @PutMapping("/{userId}/updatePoints")
    public ResponseEntity<User> updateUserPoints(@PathVariable Long userId) {
        // Trigger the update of user points
        User updatedUser = userService.updateUserPoints(userId);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<User>> getLeaderboard() {
        return ResponseEntity.ok(userService.getLeaderboard());
    }
}
