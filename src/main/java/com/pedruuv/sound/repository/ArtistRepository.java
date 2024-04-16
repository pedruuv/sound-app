package com.pedruuv.sound.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pedruuv.sound.models.Artist;
import com.pedruuv.sound.models.Song;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
    Optional<Artist> findByNameContainingIgnoreCase(String name);

    @Query("select s from Artist a JOIN a.songs s WHERE s.title ILIKE %:songWord%")
    List<Song> songsByWord(String songWord);


}
