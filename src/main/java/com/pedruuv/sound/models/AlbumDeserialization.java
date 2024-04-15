package com.pedruuv.sound.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumDeserialization(@JsonAlias("desc") String title, @JsonAlias("year") Integer year) {

}
