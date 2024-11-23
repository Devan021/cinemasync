package com.cinemasync.service;

import com.cinemasync.model.Movie;
import com.cinemasync.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Long id, Movie movieDetails) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(movieDetails.getTitle());
                    movie.setDescription(movieDetails.getDescription());
                    movie.setDuration(movieDetails.getDuration());
                    movie.setReleaseDate(movieDetails.getReleaseDate());
                    movie.setRating(movieDetails.getRating());
                    movie.setGenre(movieDetails.getGenre());
                    movie.setDirector(movieDetails.getDirector());
                    movie.setCast(movieDetails.getCast());
                    return movieRepository.save(movie);
                });
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

