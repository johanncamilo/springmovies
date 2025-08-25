package com.software_colombia.movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.software_colombia.movies.model.Movie;
import com.software_colombia.movies.service.impl.MovieServiceImpl;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    /**
     * @param total
     * @param order
     * @return List<Movie>
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(defaultValue = "8") int total, @RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(movieService.getMovies(total, order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> get(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }
}
