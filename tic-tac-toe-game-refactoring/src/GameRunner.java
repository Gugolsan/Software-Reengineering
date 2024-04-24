//public class GameRunner {
//    public static void main(String[] args) {
//        Logic logic = new LogicPeerImpl();
//        logic.play();
//    }
//}

import java.util.Scanner;

/**
 * The entry point for the Tic Tac Toe game.
 * This class prompts the user for game settings and starts the game based on the selected mode.
 * It supports both player-vs-player and player-vs-computer modes.
 * The board size is configurable, and input validation is performed for game mode selection.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @class GameRunner
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public class GameRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Scanner to read user input
        int boardSize; // Variable to store the board size

        // Prompt the user for the board size and validate the input
        do {
            System.out.println("Enter the size of the board (must be equal to 3 or greater):");
            boardSize = scanner.nextInt(); // Read the board size from the user
        } while (boardSize < 3); // Repeat until a valid size is entered

        // Prompt the user to choose the game mode
        System.out.println("Choose game mode: \n1. Player vs Player \n2. Player vs Computer");
        int gameMode = scanner.nextInt(); // Read the game mode from the user

        Logic logic; // Variable to hold the game logic

        // Determine the game mode based on user input and instantiate the appropriate game logic
        if (gameMode == 1) {
            logic = new LogicPlayerVsPlayerImpl(boardSize); // Player-vs-player mode
        } else if (gameMode == 2) {
            logic = new LogicPlayerVsComputerImpl(boardSize); // Player-vs-computer mode
        } else {
            // If an invalid mode is selected, default to player-vs-player mode
            System.out.println("Invalid game mode selected. Defaulting to Player vs Player.");
            logic = new LogicPlayerVsPlayerImpl(boardSize);
        }

        logic.play(); // Start the game
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}


