package edu.pro.movierentalledgerspringboot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the pricing policy for movie rentals.
 * Defines the standard and penalty rates based on the rental duration.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class RentalPricingPolicy
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Getter
@Setter
public class RentalPricingPolicy {

    private String id; // Unique identifier for the pricing policy
    private double standardRate; // Standard rate without penalty
    private double penaltyRate; // Rate applied after the standard rental period
    private int penaltyThreshold; // Number of days after which the penalty rate is applied

    /**
     * Constructs a new RentalPricingPolicy with specified rates and threshold.
     *
     * @param standardRate      The standard rental rate per day.
     * @param penaltyRate       The penalty rate per day after the threshold.
     * @param penaltyThreshold  The number of days after which the penalty rate is applied.
     */
    public RentalPricingPolicy(double standardRate, double penaltyRate, int penaltyThreshold) {
        this.standardRate = standardRate;
        this.penaltyRate = penaltyRate;
        this.penaltyThreshold = penaltyThreshold;
    }
}

