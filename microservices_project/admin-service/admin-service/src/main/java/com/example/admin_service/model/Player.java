package com.example.admin_service.model;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String team;
    private int fantasyPoints;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getFantasyPoints() {
        return fantasyPoints;
    }

    public void setFantasyPoints(int fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
