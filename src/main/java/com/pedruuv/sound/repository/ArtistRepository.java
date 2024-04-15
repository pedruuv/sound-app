package com.pedruuv.sound.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedruuv.sound.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
    Optional<Artist> findByNameContainingIgnoreCase(String name);
}
