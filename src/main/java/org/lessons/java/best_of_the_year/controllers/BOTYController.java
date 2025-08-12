package org.lessons.java.best_of_the_year.controllers;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class BOTYController {

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("fullName", "Haojie Zhang");
        return "index";
    }

    private Movie[] getBestMovies() {
        Movie[] movies = new Movie[5];
        movies[0] = new Movie(1, "Interstellar");
        movies[1] = new Movie(2, "The Imitation Game");
        movies[2] = new Movie(3, "Hidden Figures");
        movies[3] = new Movie(4, "Good Will Hunting");
        movies[4] = new Movie(5, "The Theory of Everything");
        return movies;
    }

    private Song[] getBestSongs() {
        Song[] songs = new Song[5];
        songs[0] = new Song(1, "Bohemian Rhapsody");
        songs[1] = new Song(2, "Thriller");
        songs[2] = new Song(3, "Let It Be");
        songs[3] = new Song(4, "Imagine");
        songs[4] = new Song(5, "Like a Rolling Stone");
        return songs;
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable("id") int id, Model model) {

        Movie[] movies = getBestMovies();

        Movie movie = null;
        for (Movie element : movies) {
            if (element.getId() == id) {
                movie = element;
            }
        }

        if (movie != null) {
            model.addAttribute("title", movie.getTitle());
            return "movieDetail";
        } else {
            model.addAttribute("title", "Movie not found with id " + id);
            return "movieDetail";
        }

    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable("id") int id, Model model) {

        Song[] songs = getBestSongs();

        Song song = null;
        for (Song element : songs) {
            if (element.getId() == id) {
                song = element;
            }
        }

        if (song != null) {
            model.addAttribute("title", song.getTitle());
            return "songDetail";
        } else {
            model.addAttribute("title", "Song not found with id " + id);
            return "songDetail";
        }

    }

    @GetMapping("/movies")
    public String bestMovies(Model model) {
        Movie[] movies = getBestMovies();

        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs")
    public String bestSongs(Model model) {
        Song[] songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

}
