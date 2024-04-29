package edu.pro.movierentalledgerspringboot.model;

import lombok.Data;

/**
 * Represents a movie available for rental.
 * Contains details about the movie's title and genre.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class Movie
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Data
public class Movie {
    private String id; // Unique identifier for the movie
    private String title; // Title of the movie
    private Genre genre; // Genre of the movie
}

