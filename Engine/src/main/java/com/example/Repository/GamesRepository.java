package com.example.Repository;


import com.example.Entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GamesRepository extends JpaRepository<Game, UUID> {

    Optional<Game> findByTitle(String title);
    Page<Game> findByGenre(String genre, Pageable pageable);
    Page<Game> findByDeveloper(String developer, Pageable pageable);

    Page<Game> findByPlatform(String platform, Pageable pageable);
}
