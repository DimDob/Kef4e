package com.example.Service;

import com.example.Entity.Game;
import com.example.Repository.GamesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CRUDService {

    @Autowired
    GamesRepository gamesRepository;

    public Game saveInRepository(Game game) {
        Optional<Game> existingGame = gamesRepository.findByTitle(game.getTitle());
        if (existingGame.isPresent()) {
            System.out.println("hjere");
            log.info("Game with title '{}' already exists in the repository!", game.getTitle());
        } else {
            log.info("Saving game: {}", game);
            gamesRepository.save(game);
        }
        return game;
    }
}
