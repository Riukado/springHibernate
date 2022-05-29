package com.kolokwium.springHibernate.game.repository;

import com.kolokwium.springHibernate.exceptions.NotFoundException;
import com.kolokwium.springHibernate.game.models.GameEntity;
import com.kolokwium.springHibernate.game.service.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class GameRepository {
    @Autowired
    private GameDatabaseRepository gameDatabaseRepository;

    public long createCharacter(Game game){
        GameEntity gameEntity = new GameEntity(game.getCharacterName(),
                game.getCharacterLevel(),
                game.getClassName(),
                game.getPowerLevel(),
                game.getCurrency(),
                game.getLocationType(),
                game.getLocation()
        );
        GameEntity savedEntity = gameDatabaseRepository.save(gameEntity);
        return savedEntity.getId();
    }

//    public Game getCharacter(long id) throws NotFoundException {
//        GameEntity gameEntity = gameDatabaseRepository.findById(id).orElse(null);
//        if (gameEntity == null)
//            throw new NotFoundException();
//        return new Game(
//                gameEntity.getCharacterName(),
//                gameEntity.getCharacterLevel(),
//                gameEntity.getClassName(),
//                gameEntity.getPowerLevel(),
//                gameEntity.getCurrency(),
//                gameEntity.getLocationType()
//        );
//    }

    public Collection<Game> getCharacters(){
        List<Game> players = new ArrayList<>();
        for(GameEntity gameEntity : gameDatabaseRepository.findAll()){
            players.add(new Game(
                    gameEntity.getCharacterName(),
                    gameEntity.getCharacterLevel(),
                    gameEntity.getClassName(),
                    gameEntity.getPowerLevel(),
                    gameEntity.getCurrency(),
                    gameEntity.getLocationType(),
                    gameEntity.getLocation()
            ));
        }
        return players;
    }

    public void updateCharacter(long id, Game game){
        GameEntity updateGameEntity = new GameEntity(
                game.getCharacterName(),
                game.getCharacterLevel(),
                game.getClassName(),
                game.getPowerLevel(),
                game.getCurrency(),
                game.getLocationType(),
                game.getLocation()
        );
        updateGameEntity.setId(id);
        gameDatabaseRepository.save(updateGameEntity);
    }

    public void deleteCharacter(long id){
        gameDatabaseRepository.deleteById(id);
    }
}
