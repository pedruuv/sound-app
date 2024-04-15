package com.pedruuv.sound.models;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistData(@JsonAlias("desc") String name, SongData lyrics) {

}
