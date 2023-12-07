package com.example.Service;

import com.example.Entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface GamesService {
    Page<Game> save(String json, Pageable pageable);

    Optional<Game> getGame(String title);

    Page<Game> sortByGenre(String genre, Pageable pageable);

    Page<Game> getByDeveloper (String developer, Pageable pageable);

    Page<Game> getByPlatform(String platform, Pageable pageable);
}
