package com.example.Controller;

import com.example.Entity.Game;
import com.example.Service.GamesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class GamesController {
    private final GamesService gamesService;
    private final String baseApi = "https://www.freetogame.com/api/games";

    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping
    public Page<Game> getGamesFromApi(@RequestParam(defaultValue = "0") int page, Pageable pageable) throws IOException {
        String apiUrl = baseApi + "?page=" + page;
        return gamesService.save(apiUrl, pageable);
    }

    @GetMapping(value =  "/{gameTitle}")
    @ResponseBody
    public Optional<Game> getGame(@PathVariable String gameTitle) {
        return gamesService.getGame(gameTitle);
    }
}
