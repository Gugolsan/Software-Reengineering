//public class LogicPeerImpl implements Logic {
//    @Override
//    public void play() {
//
//    }
//}

import java.util.Scanner;

/**
 * Implements the logic for a player-vs-player (PvP) Tic Tac Toe game.
 * This class handles the game flow, including player turns, move validation,
 * checking for wins or draws, and switching turns between players.
 * It provides a text-based interface for two players to play the game.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @class LogicPlayerVsPlayerImpl
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public class LogicPlayerVsPlayerImpl implements Logic {
    private final PlayGround playGround; // The game board
    private final Scanner scanner; // Scanner to read player input
    private Symbol currentPlayer; // The current player (X or O)

    /**
     * Constructs a new PlayerVsPlayerLogic with the specified board size.
     * Initializes the game board and sets the starting player to X.
     *
     * @param boardSize the size of the Tic Tac Toe board (must be a positive integer)
     */
    public LogicPlayerVsPlayerImpl(int boardSize) {
        playGround = new PlayGround(boardSize); // Create a new game board of the given size
        scanner = new Scanner(System.in); // Initialize the scanner
        currentPlayer = Symbol.X; // Set the starting player to X
    }

    /**
     * Starts and manages the PvP game flow.
     * Players take turns to input their moves until the game ends in a win or draw.
     * The game continues until a player wins or there are no more empty cells on the board.
     */
    @Override
    public void play() {
        boolean playing = true; // Flag to keep the game running
        while (playing) {
            playGround.printBoard(); // Display the current state of the board
            // Prompt the current player for their move
            System.out.println("Player " + currentPlayer.getValue() + "'s turn. Enter row and column (1-based):");
            int row = scanner.nextInt() - 1; // Convert 1-based input to 0-based index for row
            int col = scanner.nextInt() - 1; // Convert 1-based input to 0-based index for column
            // Attempt to place the player's symbol on the board
            if (playGround.setSymbol(row, col, currentPlayer)) {
                // If the move is invalid, prompt the player to try again
                System.out.println("Invalid move. Try again.");
                continue; // Skip the rest of the loop and start over
            }
            // Check if the current player has won the game
            if (playGround.checkWin(currentPlayer)) {
                playGround.printBoard(); // Display the final state of the board
                // Announce the winner and end the game
                System.out.println("Game over! Player " + currentPlayer.getValue() + " wins!");
                playing = false; // Set the flag to false to exit the game loop
            } else if (playGround.isFull()) {
                // If the board is full and there's no winner, it's a draw
                playGround.printBoard(); // Display the final state of the board
                System.out.println("Game over! It's a draw!"); // Announce the draw
                playing = false; // Set the flag to false to exit the game loop
            } else {
                // If the game is not over, switch to the other player
                currentPlayer = (currentPlayer == Symbol.X) ? Symbol.O : Symbol.X;
            }
        }
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
