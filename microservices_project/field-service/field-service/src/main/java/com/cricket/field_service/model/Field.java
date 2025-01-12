package com.cricket.field_service.model;
import jakarta.persistence.*;
@Entity
public class Field {

    @Id
    private int id;
    private String name;
    private String span;
    private int matches;
    private int catches;
    private int stumpings;
    private int runOuts;
    private int totalFielding;

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

    public int getCatches() {
        return catches;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public int getStumpings() {
        return stumpings;
    }

    public void setStumpings(int stumpings) {
        this.stumpings = stumpings;
    }

    public int getRunOuts() {
        return runOuts;
    }

    public void setRunOuts(int runOuts) {
        this.runOuts = runOuts;
    }

    public int getTotalFielding() {
        return totalFielding;
    }

    public void setTotalFielding(int totalFielding) {
        this.totalFielding = totalFielding;
    }
}
