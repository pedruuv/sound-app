package com.pedruuv.sound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedruuv.sound.main.Main;
import com.pedruuv.sound.repository.ArtistRepository;

@SpringBootApplication
public class SoundApplication implements CommandLineRunner{

	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SoundApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.showMenu();
	}
}
