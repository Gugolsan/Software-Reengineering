# Overview of Movie Rental Ledger: Spring Boot Application

The Movie Rental Ledger is a Spring Boot application designed to manage and calculate rental statements for a movie rental store. This application serves as an architectural rework of previous iterations (refactoring steps), transitioning into a modern Spring Boot application with enhanced capabilities and maintainability.

## Key Features
- **Movie Management**: Manages a diverse catalog of movies, including genres such as regular, new releases and children’s movies (we can add other types).
- **Rental Tracking**: Tracks rental durations and calculates costs based on dynamic pricing strategies.
- **Statement Generation**: Provides a simple total price calculation in the browser by means of the `@RestController` Spring annotation without the detailed breakdown into a comprehensive rental statement. This streamlined approach allows for quick and efficient price calculations while maintaining the potential for future enhancements to statement detail and complexity.
- **Extensibility**: Structured to facilitate the easy addition of new features or modifications to existing algorithms. The frequent renter points algorithm can be integrated later, based on the established pricing strategy.

## Design
The application’s architecture is organized into model entities, services and controllers, each serving distinct roles within the system:

### Model Entities
- `Customer`: Manages a collection of rentals and is designed to generate billing statements. Currently, it holds customer identification and name.
- `Genre`: Enumerates the different genres of movies available for rental, providing a standardized set of categories for movie classification.
- `Movie`: Represents a movie with a title and genre classification. It serves as a Data Transfer Object (DTO) within the system.
- `Rental`: Represents the rental record of a movie for a specified duration, including the start and end times of the rental period.
- `RentalPricingPolicy`: Defines the pricing policy for different movie genres, including standard rates, penalty rates and the threshold for applying penalty rates.

### Service Layer
- `DefaultPricingStrategy`: Manages the default pricing strategies associated with each movie genre. It initializes and provides access to these policies, which are essential for calculating rental costs.
- `PriceCalculationService`: Responsible for calculating the total rental price based on the number of days rented and the applicable pricing policy.
- `RentalCalculationService`: Aggregates the total price for multiple rentals, utilizing the `PriceCalculationService` to compute individual rental costs.

### Controller Layer
- `RentalController`: Handles HTTP requests related to rentals. It provides endpoints for calculating the total price of rentals and can be extended to offer more detailed rental statements and other rental-related operations.

## Key Remarks
- **Project Structure**: Developed as a new Spring Boot project utilizing Spring Web, MongoDB and Lombok dependencies.
- **Metadata Annotations**: Metadata annotations have been added throughout the codebase. This metadata provides valuable context such as the authorship, purpose, versioning and date of creation, which is essential for maintaining a professional and well-documented codebase.
- **Code Comments**: The codebase has been thoroughly documented with enhanced comments to provide clear explanations of functionality and logic.
- **Inclusion of `@param` and `@return` Tags**: Method documentation has been enriched with @param and @return tags to explicitly describe the purpose of each parameter and the expected result returned by methods. This practice enhances the self-documenting nature of the code and aids in the generation of API documentation.
- **Consistent Formatting**: Applied consistent formatting across all Spring Boot architecture to improve readability.
- **Enhanced Readability**: The entire Spring Boot architecture has been formatted consistently in accordance with the Google Java Style Guide. This uniformity in code style improves readability and contributes to a standardized codebase, making it more approachable for developers.
- **DTO Design**: The `Movie` class, as was mentioned earlier, is treated as a Data Transfer Object (DTO) and does not contain pricing information. Pricing can be associated with movies in a separate class and persisted in the database within the `calculateTotalRentalPrice()` method.
- **Dynamic Pricing**: The `DefaultPricingStrategy` class holds active pricing strategies, which in a production environment, would be dynamically constructed from a database at application startup.
- **Database Integration**: The architecture allows for future expansion using database operations, with a dedicated repository package prepared for data persistence.
- **Flexibility for Changes**: The architecture supports the ability to change the type and pricing of movies, reflecting real-world scenarios where movies may transition, for example, between new releases and regular genres.

## Future Enhancements
- **Frequent Renter Points**: Introduce a strategy pattern for calculating frequent renter points, similar to the pricing strategy. This will allow for dynamic changes in how points are awarded based on rental types and customer loyalty.
- **Repository Implementation**: Implement the repository interfaces to connect with MongoDB for persistent data storage.
- **Service Expansion**: Extend the `DefaultPricingStrategy` to fetch and update pricing strategies from the database, allowing for real-time pricing adjustments.
- **API Development**: Develop additional RESTful endpoints to handle CRUD operations for movies, customers and rentals.
- **User Interface**: Introduce a web-based user interface to interact with the system, improving user experience and accessibility.
- **Security**: Implement security measures to protect sensitive data and ensure safe operations.

## Result Sample

To see the application in action:
1. Run the Spring Boot application.
2. Open any web browser.
3. Navigate to the HTTP endpoint by making a GET request to http://localhost:8080/rentals/calculateTotalPrice.

The response will be a formatted message displaying the total price calculated for the sample rentals. It is provided on image below:

![img.png](img.png)

## Conclusion
This Spring Boot application represents a significant step forward in the evolution of the Movie Rental Ledger project. With its current architecture, it lays the groundwork for a robust, scalable and maintainable movie rental management system. The design choices and documentation practices adopted throughout the development process aim to ensure that the application can grow and adapt to future business requirements and technological advancements.
