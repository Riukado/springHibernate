package com.kolokwium.springHibernate.game.service;

import com.kolokwium.springHibernate.game.models.Location;
import com.kolokwium.springHibernate.game.models.LocationType;
import com.kolokwium.springHibernate.game.repository.GameDatabaseRepository;

import java.util.List;

public class Game {

    private String characterName;
    private int characterLevel;
    private String className;
    private long powerLevel;
    private long currency;
    private LocationType locationType;
    private List<Location> location;

    public Game(String characterName, int characterLevel, String className, long powerLevel, long currency, LocationType locationType, List<Location> location) {
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.className = className;
        this.powerLevel = powerLevel;
        this.currency = currency;
        this.locationType = locationType;
        this.location = location;
    }


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(long powerLevel) {
        this.powerLevel = powerLevel;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public long getCurrency() {
        return currency;
    }

    public void setCurrency(long currency) {
        this.currency = currency;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Game{" +
                "characterName='" + characterName + '\'' +
                ", characterLevel=" + characterLevel +
                ", className='" + className + '\'' +
                ", powerLevel=" + powerLevel +
                ", currency=" + currency +
                ", locationType=" + locationType +
                ", location=" + location +
                '}';
    }

}

