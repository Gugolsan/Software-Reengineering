package edu.pro.movierentalledgerspringboot.service;

import edu.pro.movierentalledgerspringboot.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Calculates the total price for a collection of movie rentals.
 * It leverages the DefaultPricingStrategy to obtain the pricing policy for each movie's genre
 * and the PriceCalculationService to compute the price of each rental based on the rental duration.
 * The service sums up the prices of all rentals to provide the total cost.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class RentalCalculationService
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Service
public class RentalCalculationService {

    private final DefaultPricingStrategy defaultPricingStrategy;
    private final PriceCalculationService priceCalculationService;

    @Autowired
    public RentalCalculationService(DefaultPricingStrategy defaultPricingStrategy, PriceCalculationService priceCalculationService) {
        this.defaultPricingStrategy = defaultPricingStrategy;
        this.priceCalculationService = priceCalculationService;
    }

    /**
     * Calculates the number of days between the start and finish dates of a rental.
     *
     * @param start The start date and time of the rental.
     * @param finish The end date and time of the rental.
     * @return The total number of days rented as an integer.
     */
    private Integer calculateRentalDays(LocalDateTime start, LocalDateTime finish) {
        return (int) ChronoUnit.DAYS.between(start, finish);
    }

    /**
     * Aggregates the total price for a list of movie rentals.
     *
     * @param rentals The list of rentals for which the total price is to be calculated.
     * @return The total price for all rentals in the list as a Double.
     */
    public Double calculateTotalPriceForRentals(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(rental -> {
                    int daysRented = calculateRentalDays(rental.getStart(), rental.getFinish());
                    return priceCalculationService.calculateTotalRentalPrice(
                            daysRented,
                            defaultPricingStrategy.getPriceForGenre(rental.getMovie().getGenre())
                    );
                })
                .sum();
    }
}

