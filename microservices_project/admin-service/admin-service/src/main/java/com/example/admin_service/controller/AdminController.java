package com.example.admin_service.controller;

import com.example.admin_service.model.Match;
import com.example.admin_service.model.Player;
import com.example.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/matches")
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        return ResponseEntity.ok(adminService.addMatch(match));
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(adminService.getAllMatches());
    }

    @PostMapping("/matches/{matchId}/players")
    public ResponseEntity<Player> addPlayerToMatch(@PathVariable Long matchId, @RequestBody Player player) {
        return ResponseEntity.ok(adminService.addPlayerToMatch(matchId, player));
    }

    @GetMapping("/matches/{matchId}/players")
    public ResponseEntity<List<Player>> getPlayersByMatch(@PathVariable Long matchId) {
        return ResponseEntity.ok(adminService.getPlayersByMatch(matchId));
    }

    @PutMapping("/players/{playerId}/points")
    public ResponseEntity<Player> updatePlayerPoints(@PathVariable Long playerId, @RequestParam int points) {
        return ResponseEntity.ok(adminService.updatePlayerPoints(playerId, points));
    }
}
