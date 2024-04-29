package edu.pro.movierentalledgerspringboot.service;

import edu.pro.movierentalledgerspringboot.model.Genre;
import edu.pro.movierentalledgerspringboot.model.RentalPricingPolicy;
import org.springframework.stereotype.Service;
import java.util.EnumMap;
import java.util.Map;

/**
 * Provides a mapping of movie genres to their default rental pricing policies.
 * This service initializes the default pricing policies for each genre and offers
 * a method to retrieve the policy based on the genre of a movie.
 * The pricing policies define the standard rate, penalty rate, and the threshold
 * for applying the penalty rate.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class DefaultPricingStrategy
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@Service
public class DefaultPricingStrategy {

    private final Map<Genre, RentalPricingPolicy> defaultPrices;

    public DefaultPricingStrategy() {
        defaultPrices = new EnumMap<>(Genre.class);
        initializeDefaultPrices();
    }

    /**
     * Initializes the default pricing policies for each movie genre.
     * The policies are stored in an EnumMap for efficient access.
     */
    private void initializeDefaultPrices() {
        defaultPrices.put(Genre.REGULAR, new RentalPricingPolicy(2D, 4D, 2));
        defaultPrices.put(Genre.CHILDREN, new RentalPricingPolicy(1D, 3D, 1));
        defaultPrices.put(Genre.NEW_RELEASE, new RentalPricingPolicy(3D, 4D, 3));
    }

    /**
     * Retrieves the default rental pricing policy for the specified movie genre.
     *
     * @param genre The genre of the movie for which the pricing policy is requested.
     * @return The RentalPricingPolicy object containing the pricing details.
     */
    public RentalPricingPolicy getPriceForGenre(Genre genre) {
        return defaultPrices.get(genre);
    }
}


