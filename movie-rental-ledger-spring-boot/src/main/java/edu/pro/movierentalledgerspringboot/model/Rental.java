package edu.pro.movierentalledgerspringboot.model;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * Represents a rental transaction of a movie.
 * Stores details about the rental period and associated customer and movie.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class Rental
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Data
public class Rental {
    private String id; // Unique identifier for the rental
    private Customer customer; // The customer who rented the movie
    private Movie movie; // The movie that was rented
    private LocalDateTime start; // Start date and time of the rental
    private LocalDateTime finish; // End date and time of the rental
}

