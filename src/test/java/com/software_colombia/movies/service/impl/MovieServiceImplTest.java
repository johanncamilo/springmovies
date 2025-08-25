package com.software_colombia.movies.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.software_colombia.movies.model.Movie;
import com.software_colombia.movies.repository.MovieRepository;

public class MovieServiceImplTest {

    private Movie movie;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        movie = new Movie();
        movie.setId(1L);
        movie.setFilm("Inception");
        movie.setYear(2010);
        movie.setGenre("Sci-Fi");
        movie.setStudio("Warner Bros");
        movie.setScore(9);
    }

    @Test
    void testCreateMovie() {

        when(movieRepository.save((Movie) any(Movie.class))).thenAnswer(invocation -> {
            Movie m = invocation.getArgument(0);
            if (m.getId() == null) {
                m.setId(2L); // Simulate DB assigning an ID
            }
            return m;
        });
        assertNotNull(movieService.createMovie(movie));

        assertTrue(movie.getId() == 1L);
        assertTrue(movie.getFilm().equals("Inception"));

        Movie movie2 = new Movie(null, "Matrix", "Sci-Fi", "Warner Bros", 9, 1999);
        Movie saved = movieRepository.save(movie2);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getFilm()).isEqualTo("Matrix");

    }

    @Test
    void testGetMovieById() {

        when(movieRepository.findById((Long) any(Long.class))).thenReturn(java.util.Optional.ofNullable(movie));
        assertNotNull(movieService.getMovieById(1L));

    }

    @Test
    void testGetMovies() {

        when(movieRepository.findSpecial((Pageable) any(Sort.class))).thenReturn(Arrays.asList(movie));
        assertNotNull(movieService.getMovies(1, "asc"));
    }
}
