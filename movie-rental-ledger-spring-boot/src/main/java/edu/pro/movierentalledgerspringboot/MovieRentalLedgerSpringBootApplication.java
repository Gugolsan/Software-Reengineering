package edu.pro.movierentalledgerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot application.
 * This class launches the movie rental ledger application.
 *
 * @author Volodymyr Voroniuk
 * @project movie-rental-ledger-spring-boot
 * @class MovieRentalLedgerSpringBootApplication
 * @version 1.0.0
 * @since 23.04.24 - 23.06
 */
@SpringBootApplication
public class MovieRentalLedgerSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRentalLedgerSpringBootApplication.class, args);
	}
}

