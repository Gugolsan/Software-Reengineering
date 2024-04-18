package example.price;

import example.Movie;

public abstract class Price {

    public abstract double getPrice(int daysRented);
    public int getFrequentRenterPointsIncrement(int daysRented) {
        return 1;
    };
}