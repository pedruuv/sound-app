package com.pedruuv.sound.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Album(@JsonAlias("desc") String title, @JsonAlias("year") String year) {

}
