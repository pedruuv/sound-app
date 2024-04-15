package com.pedruuv.sound.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumData(@JsonAlias("item") List<AlbumDeserialization> album) {
} 
