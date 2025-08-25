package com.software_colombia.movies.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "Film", nullable = false, length = 100)
    private String film;
    
    @Column(name = "Genre", length = 50)
    private String genre;
    
    @Column(name = "Studio", length = 100)
    private String studio;
    
    @Column(name = "Score")
    private Integer score;
    
    @Column(name = "Year")
    private Integer year;    
}
