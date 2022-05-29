package com.kolokwium.springHibernate.game.repository;

import com.kolokwium.springHibernate.game.models.GameEntity;
import com.kolokwium.springHibernate.game.models.LocationType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDatabaseRepository extends CrudRepository<GameEntity, Long>{
    @Query("FROM GameEntity ge WHERE ge.characterLevel > :characterLevel")
    GameEntity onlyInputLevelOrHigher(
            @Param("characterLevel") int characterLevel
            );
    @Query("FROM GameEntity ge WHERE ge.characterName = :characterName")
    void findCharacterByName(
            @Param("characterName") String characterName
    );
    @Query("FROM GameEntity ge WHERE ge.characterLevel > :characterLevel AND ge.powerLevel > :powerLevel")
    void filterByLevelAndPower(
            @Param("characterLevel") int characterLevel,
            @Param("powerLevel") long powerLevel
    );
    @Modifying
    @Query("UPDATE GameEntity ge SET ge.characterName = ?1, ge.characterLevel = ?2, ge.className = ?3, ge.powerLevel = ?4, ge.currency = ?5, ge.locationType = ?6 WHERE ge.id = ?7")
    void updateCharacterById(String characterName, int characterLevel, String className, long powerLevel, long currency, LocationType locationType, long id);
}
