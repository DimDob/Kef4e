package com.example.Service;

import com.example.Entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface GamesService {
    Page<Game> save(String json, Pageable pageable);
}
