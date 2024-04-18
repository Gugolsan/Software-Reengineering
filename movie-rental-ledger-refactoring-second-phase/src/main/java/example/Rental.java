package example;

class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        // return getMovie().charge(getDaysRented());
        return movie.getPrice().getPrice(daysRented);
    }

    int getFrequentRenterPointsIncrement() {
        // return getMovie().getFrequentRenterPoints(getDaysRented());
        return movie.getPrice().getFrequentRenterPointsIncrement(daysRented);
    }

}
