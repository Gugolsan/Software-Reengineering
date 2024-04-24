/**
 * Represents the logic for playing a game.
 * Implementations of this interface define the rules and behavior of the game.
 * The `play` method is responsible for managing the game flow.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @interface Logic
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public interface Logic {
    /**
     * Starts the game and manages the game flow.
     * Implementations should handle player moves, computer moves (if applicable),
     * win conditions, and draw conditions.
     */
    void play();
}

