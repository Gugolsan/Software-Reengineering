package edu.pro.movierentalledgerspringboot.controller;

import edu.pro.movierentalledgerspringboot.model.Customer;
import edu.pro.movierentalledgerspringboot.model.Genre;
import edu.pro.movierentalledgerspringboot.model.Movie;
import edu.pro.movierentalledgerspringboot.model.Rental;
import edu.pro.movierentalledgerspringboot.service.RentalCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for handling rental-related requests.
 * Provides endpoints for calculating the total price of movie rentals.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class RentalController
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalCalculationService rentalService;

    /**
     * Constructs a RentalController with the necessary rental calculation service.
     *
     * @param rentalService The service used for calculating rental prices.
     */
    @Autowired
    public RentalController(RentalCalculationService rentalService) {
        this.rentalService = rentalService;
    }

    /**
     * Calculates the total price for a list of sample rentals.
     *
     * @return The total price for all sample rentals.
     */
    @GetMapping("/calculateTotalPrice")
    public ResponseEntity<String> calculateTotalPrice() {
        // Initialize a customer
        Customer customer = new Customer();
        customer.setId("cust123");
        customer.setName("John Doe");

        // Initialize movies of different genres
        Movie regularMovie = new Movie();
        regularMovie.setId("mov456");
        regularMovie.setTitle("The Godfather");
        regularMovie.setGenre(Genre.REGULAR);

        Movie childrenMovie = new Movie();
        childrenMovie.setId("mov123");
        childrenMovie.setTitle("The Lion King");
        childrenMovie.setGenre(Genre.CHILDREN);

        Movie newReleaseMovie = new Movie();
        newReleaseMovie.setId("mov789");
        newReleaseMovie.setTitle("Avengers: Endgame");
        newReleaseMovie.setGenre(Genre.NEW_RELEASE);

        // Create rental records for the movies
        Rental regularRental = new Rental();
        regularRental.setId("rent123");
        regularRental.setMovie(regularMovie);
        regularRental.setCustomer(customer);
        regularRental.setStart(LocalDateTime.now().minusDays(2));
        regularRental.setFinish(LocalDateTime.now());

        Rental childrenRental = new Rental();
        childrenRental.setId("rent456");
        childrenRental.setMovie(childrenMovie);
        childrenRental.setCustomer(customer);
        childrenRental.setStart(LocalDateTime.now().minusDays(4));
        childrenRental.setFinish(LocalDateTime.now());

        Rental newReleaseRental = new Rental();
        newReleaseRental.setId("rent789");
        newReleaseRental.setMovie(newReleaseMovie);
        newReleaseRental.setCustomer(customer);
        newReleaseRental.setStart(LocalDateTime.now().minusDays(7));
        newReleaseRental.setFinish(LocalDateTime.now());

        // Compile the list of rentals
        List<Rental> rentals = Arrays.asList(childrenRental, regularRental, newReleaseRental);

        // Calculate and return the total price for the rentals
        double totalPrice = rentalService.calculateTotalPriceForRentals(rentals);
        String responseMessage = String.format("The total price for all rentals is: **$%.2f**", totalPrice);
        return ResponseEntity.ok(responseMessage);
    }
}



