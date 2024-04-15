package com.pedruuv.sound.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs;


    public Artist(ArtistData artist) {
        this.name = artist.name();
    }


    public List<Song> getSongs() {
        return this.songs;
    }

    public void setSongs(List<Song> songs) {
        songs.forEach(s -> s.setArtist(this));
        this.songs = songs;
    }


    public Artist() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artist: ").append(name).append("\n");
        sb.append("Songs:\n");
        // for (Song song : songs) {
        //     sb.append(" - ").append(song + "\n");
        // }
        // sb.append("Albums:\n");
        // for (Album album : albums.album()) {
        //     sb.append(album.title()).append(" - " + album.year() + "\n");
        // }
        return sb.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
