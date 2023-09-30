package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonIgnore
    private UUID id;

    @Column(name = "Title")
    @JsonProperty("title")
    private String title;

    @Column(name = "thumbnail")
    @JsonProperty("thumbnail")
    private String thumbnailUrl;

    @Column(name = "short_description", length = 1000)
    @JsonProperty("short_description")
    private String description;

    @Column(name = "game_url")
    @JsonProperty("game_url")
    private String gameUrl;

    @Column(name = "Genre")
    @JsonProperty("genre")
    private String genre;

    @Column(name = "Platform")
    @JsonProperty("platform")
    private String platform;

    @Column(name = "Publisher")
    @JsonProperty("publisher")
    private String publisher;

    @Column(name = "Developer")
    @JsonProperty("developer")
    private String developer;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    @JsonProperty("release_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @Column(name = "freetogame_profile_url")
    @JsonProperty("freetogame_profile_url")
    private String freeToGameProfileUrl;

}
