package com.example.Controller;


import com.example.Entity.Game;
import com.example.Service.GamesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class GamesController {
    private final GamesService gamesService;

    private final String baseAPI = "https://www.freetogame.com/";

    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping(value = "/games")
    public Page<Game> getGamesFromApi(Pageable pageable) throws IOException {
        return gamesService.save(baseAPI + "/api/games", pageable);
    }

}
