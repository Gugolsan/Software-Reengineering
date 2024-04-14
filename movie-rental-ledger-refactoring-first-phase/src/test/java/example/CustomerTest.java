package example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static example.Movie.MovieType.*;
import static org.junit.Assert.assertEquals;

// The CustomerTest class contains tests for the Customer class.
public class CustomerTest {

    // Declare a Customer object to be used in the tests.
    private Customer customer;
    // Declare Movie objects for each movie category to be used in the tests.
    private Movie movieRembo; // Represents a regular movie.
    private Movie movieLOTR; // Represents a new release movie, abbreviated as LOTR.
    private Movie movieHarryPotter; // Represents a children's movie.

    // The setUp method initializes the test environment before each test.
    @Before
    public void setUp() {
        // Initialize the movie objects with their respective titles and categories.
        movieRembo = new Movie("Rembo", REGULAR);
        movieLOTR = new Movie("Lord of the Rings", NEW_RELEASE);
        movieHarryPotter = new Movie("Harry Potter", CHILDRENS);

        // Create a new Customer object with a name and a list of rentals.
        customer = new Customer("John Doe", List.of(
                new Rental(movieRembo, 1), // Add a rental for the movie "Rembo".
                new Rental(movieLOTR, 4), // Add a rental for "Lord of the Rings".
                new Rental(movieHarryPotter, 5) // Add a rental for "Harry Potter".
        ));
    }

    // Test for a single new release movie rented for three days
    // Expected result: Amount owed is 9.0, Frequent renter points earned: 2
    @Test
    public void statementForSingleNewReleaseMovieRentedThreeDays() {
        customer = new Customer("John Doe", List.of(new Rental(movieLOTR, 3)));
        String expected = """
                Rental Record for John Doe
                \tLord of the Rings\t9.0
                Amount owed is 9.0
                You earned 2 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a single children's movie rented for four days
    // Expected result: Amount owed is 3.0, Frequent renter points earned: 1
    @Test
    public void statementForSingleChildrensMovieRentedFourDays() {
        customer = new Customer("John Doe", List.of(new Rental(movieHarryPotter, 4)));
        String expected = """
                Rental Record for John Doe
                \tHarry Potter\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a single regular movie rented for two days
    // Expected result: Amount owed is 2.0, Frequent renter points earned: 1
    @Test
    public void statementForSingleRegularMovieRentedTwoDays() {
        customer = new Customer("John Doe", List.of(new Rental(movieRembo, 2)));
        String expected = """
                Rental Record for John Doe
                \tRembo\t2.0
                Amount owed is 2.0
                You earned 1 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a single regular movie rented for more than two days
    // Expected result: Amount owed is 3.5, Frequent renter points earned: 1
    @Test
    public void statementForRegularMovieRentedMoreThanTwoDays() {
        customer = new Customer("John Doe", List.of(new Rental(movieRembo, 3)));
        String expected = """
                Rental Record for John Doe
                \tRembo\t3.5
                Amount owed is 3.5
                You earned 1 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a single new release movie rented for one day
    // Expected result: Amount owed is 3.0, Frequent renter points earned: 1
    @Test
    public void statementForNewReleaseMovieRentedOneDay() {
        customer = new Customer("John Doe", List.of(new Rental(movieLOTR, 1)));
        String expected = """
                Rental Record for John Doe
                \tLord of the Rings\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a single children's movie rented for more than three days
    // Expected result: Amount owed is 3.0, Frequent renter points earned: 1
    @Test
    public void statementForChildrensMovieRentedMoreThanThreeDays() {
        customer = new Customer("John Doe", List.of(new Rental(movieHarryPotter, 4)));
        String expected = """
                Rental Record for John Doe
                \tHarry Potter\t3.0
                Amount owed is 3.0
                You earned 1 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for multiple regular movies rented for varying days
    // Expected result: Amount owed is 7.5, Frequent renter points earned: 3
    @Test
    public void statementForMultipleRegularMovies() {
        customer = new Customer("John Doe", List.of(
                new Rental(movieRembo, 1),
                new Rental(movieRembo, 2),
                new Rental(movieRembo, 3)
        ));
        String expected = """
                Rental Record for John Doe
                \tRembo\t2.0
                \tRembo\t2.0
                \tRembo\t3.5
                Amount owed is 7.5
                You earned 3 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for multiple new release movies rented for varying days
    // Expected result: Amount owed is 18.0, Frequent renter points earned: 5
    @Test
    public void statementForMultipleNewReleaseMovies() {
        customer = new Customer("John Doe", List.of(
                new Rental(movieLOTR, 1),
                new Rental(movieLOTR, 2),
                new Rental(movieLOTR, 3)
        ));
        String expected = """
                Rental Record for John Doe
                \tLord of the Rings\t3.0
                \tLord of the Rings\t6.0
                \tLord of the Rings\t9.0
                Amount owed is 18.0
                You earned 5 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for multiple children's movies rented for varying days
    // Expected result: Amount owed is 4.5, Frequent renter points earned: 3
    @Test
    public void statementForMultipleChildrensMovies() {
        customer = new Customer("John Doe", List.of(
                new Rental(movieHarryPotter, 1),
                new Rental(movieHarryPotter, 2),
                new Rental(movieHarryPotter, 3)
        ));
        String expected = """
                Rental Record for John Doe
                \tHarry Potter\t1.5
                \tHarry Potter\t1.5
                \tHarry Potter\t1.5
                Amount owed is 4.5
                You earned 3 frequent renter points""";
        assertEquals(expected, customer.statement());
    }

    // Test for a mix of regular, new release, and children's movies rented
    // Expected result: Amount owed is 8.0, Frequent renter points earned: 3
    @Test
    public void statementForMixOfMovies() {
        customer = new Customer("John Doe", List.of(
                new Rental(movieRembo, 2),
                new Rental(movieLOTR, 1),
                new Rental(movieHarryPotter, 4)
        ));
        String expected = """
                Rental Record for John Doe
                \tRembo\t2.0
                \tLord of the Rings\t3.0
                \tHarry Potter\t3.0
                Amount owed is 8.0
                You earned 3 frequent renter points""";
        assertEquals(expected, customer.statement());
    }
}
