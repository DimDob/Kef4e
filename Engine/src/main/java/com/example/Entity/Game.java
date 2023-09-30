package com.example.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Title")
    private String title;

    @Column(name = "ThumbnailURL")
    private String thumbnailUrl;

    @Column(name = "Description")
    private String description;

    @Column(name = "GameURL")
    private String gameUrl;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Platform")
    private String platform;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "Developer")
    private String developer;

    @Column(name = "ReleaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "FreeToGameProfileURL")
    private String freeToGameProfileUrl;

}
