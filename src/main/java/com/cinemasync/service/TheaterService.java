package com.cinemasync.service;

import com.cinemasync.model.Theater;
import com.cinemasync.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Optional<Theater> getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Optional<Theater> updateTheater(Long id, Theater theaterDetails) {
        return theaterRepository.findById(id)
                .map(theater -> {
                    theater.setName(theaterDetails.getName());
                    theater.setLocation(theaterDetails.getLocation());
                    theater.setCapacity(theaterDetails.getCapacity());
                    return theaterRepository.save(theater);
                });
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}

