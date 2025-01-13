package com.example.admin_service.service;

import com.example.admin_service.model.Match;
import com.example.admin_service.model.Player;
import com.example.admin_service.repositories.MatchRepository;
import com.example.admin_service.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Player addPlayerToMatch(Long matchId, Player player) {
        Match match = matchRepository.findById(matchId).orElseThrow();
        player.setMatch(match);
        return playerRepository.save(player);
    }

    public List<Player> getPlayersByMatch(Long matchId) {
        return playerRepository.findByMatchId(matchId);
    }

    public Player updatePlayerPoints(Long playerId, int points) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setFantasyPoints(points);
        return playerRepository.save(player);
    }
}
