package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BOTYController {

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("fullName", "Haojie Zhang");
        return "index";
    }

    private Movie[] getBestMovies() {
        Movie[] movies = new Movie[3];
        movies[0] = new Movie(1, "Interstellar");
        movies[1] = new Movie(2, "The Imitation Game");
        movies[2] = new Movie(3, "Hidden Figures");
        return movies;
    }

    private Song[] getBestSongs() {
        Song[] songs = new Song[3];
        songs[0] = new Song(1, "The Days");
        songs[1] = new Song(2, "Shape of You");
        songs[2] = new Song(3, "Viva La Vida");
        return songs;
    }

    @GetMapping("/movies")
    public String bestMovies(Model model) {

        String bestMovies = "";
        Movie[] movies = getBestMovies();
        for (Movie movie : movies) {
            bestMovies += movie.toString();
        }

        model.addAttribute("bestMovies", bestMovies);
        return "movies";

    }

    @GetMapping("/songs")
    public String bestSongs(Model model) {

        String bestSongs = "";
        Song[] songs = getBestSongs();
        for (Song song : songs) {
            bestSongs += song.toString();
        }

        model.addAttribute("bestSongs", bestSongs);
        return "songs";

    }

}
