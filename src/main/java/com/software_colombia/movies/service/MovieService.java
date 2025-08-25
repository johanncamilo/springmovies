package com.software_colombia.movies.service;

import java.util.List;
import java.util.Optional;

import com.software_colombia.movies.model.Movie;

public interface MovieService {
    public List<Movie> getMovies(int total, String order);
    public Optional<Movie> getMovieById(Long id);
    public Movie createMovie(Movie movie);
}
