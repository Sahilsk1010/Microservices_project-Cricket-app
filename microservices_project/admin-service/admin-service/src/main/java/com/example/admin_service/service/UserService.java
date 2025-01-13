package com.example.admin_service.service;

import com.example.admin_service.model.Player;
import com.example.admin_service.model.User;
import com.example.admin_service.model.UserTeam;
import com.example.admin_service.repositories.PlayerRepository;
import com.example.admin_service.repositories.UserRepository;
import com.example.admin_service.repositories.UserTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTeamRepository userTeamRepository;

    @Autowired
    private PlayerRepository playerRepository;  // <-- Add the @Autowired annotation here

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add player to a user's team
    public UserTeam addPlayerToTeam(Long userId, Long playerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + playerId));

        UserTeam userTeam = new UserTeam();
        userTeam.setUser(user);
        userTeam.setPlayer(player);
        userTeam.setPoints(player.getFantasyPoints());

        return userTeamRepository.save(userTeam);
    }

    // Update user points based on the points from the selected players in their team
    public User updateUserPoints(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        List<UserTeam> userTeam = userTeamRepository.findByUserId(userId);
        int totalPoints = userTeam.stream().mapToInt(UserTeam::getPoints).sum();

        user.setTotalPoints(totalPoints);

        return userRepository.save(user);
    }

    // Get the leaderboard (all users with their total points)
    public List<User> getLeaderboard() {
        return userRepository.findAll();
    }
}
