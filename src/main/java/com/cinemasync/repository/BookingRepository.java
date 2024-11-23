package com.cinemasync.model;

import jakarta.persistence.*;

@Entity
public class BookingRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Integer capacity;

    // Getters and setters
}

