package example;

import example.price.Price;

//import static example.Movie.MovieType.NEW_RELEASE;
//import static example.Movie.MovieType.THRILLER;

public class Movie {
    private final String title;
    private final Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public String getTitle (){
        return title;
    }


//    public enum MovieType {
//        REGULAR, NEW_RELEASE, CHILDRENS, THRILLER
//    }

//    public MovieType getPriceCode() {
//        return price.priceCode;
//    }


//    double charge(int daysRented) {
//        double charge = 0;
//        //determine amounts for each line
//        switch (getPriceCode()) {
//            case REGULAR -> {
//                charge += 2;
//                if (daysRented > 2) {
//                    charge += (daysRented - 2) * 1.5;
//                }
//            }
//            case NEW_RELEASE -> charge += daysRented * 3;
//            case CHILDRENS -> {
//                charge += 1.5;
//                if (daysRented > 3) {
//                    charge += (daysRented - 3) * 1.5;
//                }
//            }
//            case THRILLER -> {
//                charge += 3.5;
//                if (daysRented > 5) {
//                    charge += (daysRented - 5) * 1.5;
//                }
//            }
//        }
//        return charge;
//    }
//
//    int getFrequentRenterPoints(int daysRented) {
//        int frequentRenterPoints = 0;
//        // add frequent renter points
//        frequentRenterPoints++;
//        // add bonus for a two day new release rental
//        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1) {
//            frequentRenterPoints++;
//        }
//        if ((getPriceCode() == THRILLER) && daysRented > 2) {
//            frequentRenterPoints++;
//        }
//        return frequentRenterPoints;
//    }

}