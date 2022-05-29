package com.kolokwium.springHibernate.game.controller;

import com.kolokwium.springHibernate.exceptions.NotFoundException;
import com.kolokwium.springHibernate.game.models.GameEntity;
import com.kolokwium.springHibernate.game.service.Game;
import com.kolokwium.springHibernate.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/character")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCharacter(@RequestBody Game gameEntity) {
        gameService.createCharacter(gameEntity);
    }

//    @GetMapping("/character/{id}")
//    public Game getCharacter(@PathVariable long id, Game gameEntity){
//        try{
//            gameEntity = gameService.getCharacter(id);
//        } catch (NotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Specified character doesn't exist.");
//        }
//        return new Game(
//                gameEntity.getCharacterName(),
//                gameEntity.getCharacterLevel(),
//                gameEntity.getClassName(),
//                gameEntity.getPowerLevel(),
//                gameEntity.getCurrency(),
//                gameEntity.getLocationType()
////                gameEntity.getLocation()
//        );
//    }

    @GetMapping("/characters")
    public Collection<GameEntity> getCharacters(){
        List<GameEntity> gameEntity = new ArrayList<>();
        for(Game characters : gameService.getCharacters()){
            gameEntity.add(new GameEntity(
                    characters.getCharacterName(),
                    characters.getCharacterLevel(),
                    characters.getClassName(),
                    characters.getPowerLevel(),
                    characters.getCurrency(),
                    characters.getLocationType(),
                    characters.getLocation()
            ));
        }
        return gameEntity;
    }

    @PutMapping("/character/{id}")
    public void updateCharacter(@RequestBody GameEntity gameEntity, @PathVariable long id) throws NotFoundException {
        gameService.updateCharacter(id,gameEntity);
    }

    @DeleteMapping("/character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable long id){
        gameService.deleteCharacter(id);
    }
}
