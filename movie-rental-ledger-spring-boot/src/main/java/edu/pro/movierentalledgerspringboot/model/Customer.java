package edu.pro.movierentalledgerspringboot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a customer of the movie rental service.
 * Stores information about the customer's identity.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class Customer
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Getter
@Setter
public class Customer {
    private String id; // Unique identifier for the customer
    private String name; // Full name of the customer
}

