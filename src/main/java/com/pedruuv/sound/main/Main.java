package com.pedruuv.sound.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.pedruuv.sound.models.Album;
import com.pedruuv.sound.models.ApiResponse;
import com.pedruuv.sound.models.Artist;
import com.pedruuv.sound.models.ArtistData;
import com.pedruuv.sound.models.Song;
import com.pedruuv.sound.repository.ArtistRepository;
import com.pedruuv.sound.service.ApiConsume;
import com.pedruuv.sound.service.ConvertData;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsume consume = new ApiConsume();
    private ConvertData converter = new ConvertData();
    private final String URL = "https://www.vagalume.com.br/";
    private ArtistRepository repository;
    private ApiResponse response;
    private List<Artist> artists = new ArrayList<>();

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option != 0) {
            var menu = """
                    1- Search Artist
                    2- Show All Artists
                    3- Search Songs
                    4- Search Albums
                    0- Exit Application
                    """;
            System.out.println(menu + "\nSelect an option:");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    searchArtist();
                    break;
                case 2:
                    showAllSearchedArtists();
                    break;
                case 3:
                    searchSongsPerArtist();
                    break;
                case 4:
                    searchAlbumsPerArtist();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option");
                    ;
            }
        }

    }

    private void searchAlbumsPerArtist() {
        showAllSearchedArtists();
        System.out.println("Type the artist name:");
        var nameArtist = scanner.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(nameArtist);

        if (artist.isPresent()) {
            var artistFound = artist.get();
            var json = consume.obterDados(URL + artistFound.getName()
                    .toLowerCase().replace(" ", "-") + "/index.js");

            ApiResponse albumData = converter.obterDados(json, ApiResponse.class);

            List<Album> albums = albumData.artist().albums().album().stream()
            .map(a -> new Album(a.title(), a.year())).toList();
            System.out.println(albums);

            artistFound.setAlbums(albums);
            repository.save(artistFound);
        } else{
            System.out.println("Artist Not Found!");
        }
    }

    private void searchSongsPerArtist() {
        showAllSearchedArtists();
        System.out.println("Type the artist name: ");
        var nameArtist = scanner.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(nameArtist);

        if (artist.isPresent()) {
            var artistFound = artist.get();
            var json = consume.obterDados(URL + artistFound.getName()
                    .toLowerCase().replace(" ", "-") + "/index.js");

            ApiResponse songsData = converter.obterDados(json, ApiResponse.class);
            List<Song> songs = songsData.artist().lyrics().songs().stream()
                    .map(s -> new Song(s.title())).toList();
            songs.forEach(System.out::println);

            artistFound.setSongs(songs);
            repository.save(artistFound);
        } else {
            System.out.println("Artist Not Found!");
        }
    }

    private void showAllSearchedArtists() {
        artists = repository.findAll();
        artists.stream().forEach(System.out::println);
    }

    private void searchArtist() {
        ArtistData data = getArtistData();
        Artist artist = new Artist(data);
        repository.save(artist);
    }

    private ArtistData getArtistData() {
        System.out.println("Digite o nome do artista: ");
        var artist = scanner.nextLine();
        var json = consume.obterDados(URL + artist.toLowerCase().replace(" ", "-") + "/index.js");

        response = converter.obterDados(json, ApiResponse.class);

        ArtistData artistData = response.artist();
        return artistData;
    }
}
