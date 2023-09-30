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
                crudService.saveInRepository(game);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return getPageable((PageRequest) pageable);
    }

    private Page<Game> getPageable(PageRequest pageable) {
        int totalElements = (int) gamesRepository.count();
        int pageSize = Integer.MAX_VALUE; //set to 20 per page
        int pageNumber = pageable.getPageNumber();

        pageable = PageRequest.of(pageNumber, pageSize);
        List<Game> games = gamesRepository.findAll(pageable).getContent();
        Page<Game> page = new PageImpl<>(games, pageable, totalElements);

        return page;
    }
}
