package edu.pro.movierentalledgerspringboot.service;

import edu.pro.movierentalledgerspringboot.model.RentalPricingPolicy;
import org.springframework.stereotype.Service;

/**
 * Service that calculates the total rental price based on the rental duration and pricing policy.
 * It determines whether the rental period has exceeded the penalty threshold and applies the appropriate rate.
 * This service is used to encapsulate the pricing logic for rentals.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class PriceCalculationService
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Service
public class PriceCalculationService {

    /**
     * Calculates the total price for renting a movie based on the number of days rented and the pricing policy.
     *
     * @param daysRented The number of days the movie has been rented.
     * @param pricingPolicy The pricing policy containing penalty thresholds and prices.
     * @return The total price for the rental period.
     */
    public Double calculateTotalRentalPrice(Integer daysRented, RentalPricingPolicy pricingPolicy) {
        // Check if the rental period is within the penalty-free duration
        if (daysRented <= pricingPolicy.getPenaltyThreshold()) {
            // If within penalty-free duration, charge the standard price
            return pricingPolicy.getStandardRate();
        } else {
            // If beyond penalty-free duration, calculate penalty price
            int daysWithPenalty = daysRented - pricingPolicy.getPenaltyThreshold();
            return pricingPolicy.getStandardRate() + (pricingPolicy.getPenaltyRate() * daysWithPenalty);
        }
    }
}
