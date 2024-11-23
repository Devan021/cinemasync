package com.cinemasync.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String duration;
    private LocalDate releaseDate;
    private Double rating;

    @ElementCollection
    private Set<String> genre;

    private String director;

    @ElementCollection
    private Set<String> cast;

    // Getters and setters
}

