package com.software_colombia.movies.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.software_colombia.movies.model.Movie;
import com.software_colombia.movies.repository.MovieRepository;
import com.software_colombia.movies.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    
    @Override
    public List<Movie> getMovies(int total, String order) {

        Sort sort;

        if ("desc".equalsIgnoreCase(order)) {
            sort = Sort.by(Sort.Direction.DESC, "film");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "film");
        }

         // Crea el objeto Pageable con el tamaño de página (limit) y el orden
        Pageable pageable = PageRequest.of(0, total, sort);

        return movieRepository.findSpecial(pageable);
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie createMovie(Movie movie) {

        return movieRepository.save(movie);
    }    
}
