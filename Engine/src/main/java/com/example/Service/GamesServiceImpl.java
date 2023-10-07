package com.example.Service;

import com.example.Entity.Game;
import com.example.Repository.GamesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class GamesServiceImpl implements GamesService {

    private final ObjectMapper objectMapper;
    private final CRUDService crudService;

    @Autowired
    private GamesRepository gamesRepository;

    public GamesServiceImpl(ObjectMapper objectMapper, CRUDService crudService) {
        this.objectMapper = objectMapper;
        this.crudService = crudService;
    }

    public Page<Game> save(String json, Pageable pageable) {
        RestTemplate restTemplate = new RestTemplate();
        String gamesJson = restTemplate.getForObject(json, String.class);
        return saveGames(gamesJson, pageable);
    }

    private Page<Game> saveGames(String gamesJson, Pageable pageable) {
        try {
            Game[] games = objectMapper.readValue(gamesJson, Game[].class);

            for (Game game : games) {
                game.setId(UUID.randomUUID());
                if (gamesRepository.findByTitle(game.getTitle()).isEmpty()) {
                    gamesRepository.save(game);
                    log.info("Saving game {} into repository", game);

                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return getPageable((PageRequest) pageable);
    }

    private Page<Game> getPageable(PageRequest pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = 20;

        pageable = PageRequest.of(pageNumber, pageSize);

        return gamesRepository.findAll(pageable);
    }


    public Optional<Game> getGame(String title) {

        Optional<Game> game = gamesRepository.findByTitle(title);
        if (game.isEmpty()) {
            log.info("Game with title " + title + " has not been found!");
        }
        return game;
    }
}
