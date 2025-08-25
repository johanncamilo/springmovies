package com.software_colombia.movies.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.software_colombia.movies.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> findSpecial(Pageable pageable);

}

