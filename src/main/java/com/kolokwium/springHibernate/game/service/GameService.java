package com.kolokwium.springHibernate.game.service;

import com.kolokwium.springHibernate.exceptions.NotFoundException;
import com.kolokwium.springHibernate.game.models.GameEntity;
import com.kolokwium.springHibernate.game.repository.GameDatabaseRepository;
import com.kolokwium.springHibernate.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class GameService {
    @Autowired
    GameDatabaseRepository gameDatabaseRepository;
    @Autowired
    GameRepository gameRepository;

    @Autowired
    @Qualifier(value = "returnTrue")
    private boolean ValueTrue;

    public void createCharacter(Game gameEntity){
        Game player = new Game(
                gameEntity.getCharacterName(),
                gameEntity.getCharacterLevel(),
                gameEntity.getClassName(),
                gameEntity.getPowerLevel(),
                gameEntity.getCurrency(),
                gameEntity.getLocationType(),
                gameEntity.getLocation()
        );
        gameRepository.createCharacter(player);
    }

//    public Game getCharacter(long id) throws NotFoundException {
//        return gameRepository.getCharacter(id);
//    }

    public Collection<Game> getCharacters(){
        return gameRepository.getCharacters();
    }

    public void updateCharacter(long id, GameEntity gameEntity) throws NotFoundException{
        Game player = new Game(
                gameEntity.getCharacterName(),
                gameEntity.getCharacterLevel(),
                gameEntity.getClassName(),
                gameEntity.getPowerLevel(),
                gameEntity.getCurrency(),
                gameEntity.getLocationType(),
                gameEntity.getLocation()
        );
        gameRepository.updateCharacter(id, player);
    }

    public void deleteCharacter(long id){
        gameDatabaseRepository.deleteById(id);
    }

    @Transactional
    public void trade(long from, long to, long currency){
        GameEntity player1 = gameDatabaseRepository.findById(from).get();
        if (player1.getCurrency() >= currency) {
            player1.setCurrency(player1.getCurrency() - currency);
            gameDatabaseRepository.save(player1);
            GameEntity player2 = gameDatabaseRepository.findById(to).get();
            player2.setCurrency(player2.getCurrency() + currency);
            gameDatabaseRepository.save(player2);
        } else
            throw new RuntimeException("Not enough currency to make a trade!");
    }

}
