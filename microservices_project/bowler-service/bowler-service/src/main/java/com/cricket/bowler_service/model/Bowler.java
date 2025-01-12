package com.cricket.bowler_service.model;

import jakarta.persistence.*;
@Entity
public class Bowler {

    @Id
    private int id;
    private String name;
    private String span;
    private int matches;
    private int wickets;
    private String bestBowling;
    private double average;
    private double economyRate;
    private double strikeRate;
    private int fourWickets;
    private int fiveWickets;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String getBestBowling() {
        return bestBowling;
    }

    public void setBestBowling(String bestBowling) {
        this.bestBowling = bestBowling;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(double economyRate) {
        this.economyRate = economyRate;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getFourWickets() {
        return fourWickets;
    }

    public void setFourWickets(int fourWickets) {
        this.fourWickets = fourWickets;
    }

    public int getFiveWickets() {
        return fiveWickets;
    }

    public void setFiveWickets(int fiveWickets) {
        this.fiveWickets = fiveWickets;
    }
}
