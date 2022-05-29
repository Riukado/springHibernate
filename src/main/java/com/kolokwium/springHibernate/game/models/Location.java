package com.kolokwium.springHibernate.game.models;

import com.kolokwium.springHibernate.game.service.Game;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Characters_Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;
    private String name;
    @ManyToOne //wiele postaci na jednej lokacji
    private GameEntity characters;

    public Location(){}

    public Location(String name) {
        this.name = name;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public List<GameEntity> getCharacters() {
//        return characters;
//    }
//
//    public void setCharacters(List<GameEntity> characters) {
//        this.characters = characters;
//    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name +
                '}';
    }
}
