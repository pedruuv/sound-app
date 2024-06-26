package com.pedruuv.sound.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistData(@JsonAlias("desc") String name, SongData lyrics, AlbumData albums
, @JsonAlias("genre") List<GenreData> genres) {

}
