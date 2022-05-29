package com.kolokwium.springHibernate.game.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GameEntity")
public class GameEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "NAZWA_POSTACI", length = 30)
    private String characterName;
    @Column(name = "POZIOM_POSTACI")
    private int characterLevel;
    @Column(name = "KLASA_POSTACI", length = 20)
    private String className;
    @Column(name = "MOC_POSTACI")
    private long powerLevel;
    @Column(name = "ILOSC_POSIADANEJ_WALUTY")
    private long currency;
    @Column(name = "TYP_LOKACJI")
    @Enumerated(value = EnumType.STRING)
    private LocationType locationType;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Location> location;

    public GameEntity(){
    }

    public GameEntity(String characterName, int characterLevel, String className, long powerLevel, long currency, LocationType locationType, List<Location> location) {
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.className = className;
        this.powerLevel = powerLevel;
        this.currency = currency;
        this.locationType = locationType;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public long getCurrency() {
        return currency;
    }

    public void setCurrency(long currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "characterName='" + characterName + '\'' +
                ", characterLevel=" + characterLevel +
                ", className='" + className + '\'' +
                ", powerLevel=" + powerLevel +
                ", currency=" + currency +
                ", locationType=" + locationType +
                '}';
    }
}
