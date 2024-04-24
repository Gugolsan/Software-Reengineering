import java.util.Random;
import java.util.Scanner;

/**
 * Implements the logic for a player-vs-computer Tic Tac Toe game.
 * This class handles the game flow, including player and computer turns,
 * move validation, checking for wins or draws, and switching turns.
 * It provides a text-based interface for the player to play against the computer.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @class LogicPlayerVsComputerImpl
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public class LogicPlayerVsComputerImpl implements Logic {
    private final PlayGround playGround; // The game board
    private final Scanner scanner; // Scanner to read player input
    private final Random random; // Random generator for computer moves
    private Symbol currentPlayer; // The current player (X or O)

    /**
     * Constructs a new PlayerVsComputerLogic with the specified board size.
     * Initializes the game board and sets the starting player to X.
     *
     * @param boardSize the size of the Tic Tac Toe board (must be a positive integer)
     */
    public LogicPlayerVsComputerImpl(int boardSize) {
        playGround = new PlayGround(boardSize); // Create a new game board of the given size
        scanner = new Scanner(System.in); // Initialize the scanner
        random = new Random(); // Initialize the random generator
        currentPlayer = Symbol.X; // Set the starting player to X
    }

    /**
     * Starts and manages the player-vs-computer game flow.
     * Players take turns to input their moves, and the computer generates random moves.
     * The game continues until a player wins or there are no more empty cells on the board.
     */
    @Override
    public void play() {
        boolean playing = true; // Flag to keep the game running
        while (playing) {
            playGround.printBoard(); // Display the current state of the board.
            if (currentPlayer == Symbol.X) { // Check if it's the human player's turn (Symbol.X)
                // Prompt the human player for their move
                System.out.println("Player " + currentPlayer.getValue() + "'s turn. Enter row and column (1-based):");
                int row = scanner.nextInt() - 1; // Convert 1-based input to 0-based index for row
                int col = scanner.nextInt() - 1; // Convert 1-based input to 0-based index for column
                // Attempt to place the player's symbol on the board
                if (playGround.setSymbol(row, col, currentPlayer)) {
                    // If the move is invalid, prompt the player to try again
                    System.out.println("Invalid move. Try again.");
                    continue; // Skip the rest of the loop and start over
                }
            } else {
                // If it's the computer's turn (Symbol.O), calculate a random move
                int row, col;
                do {
                    // Generate random row and column indices within the bounds of the board size
                    row = random.nextInt(playGround.getSize());
                    col = random.nextInt(playGround.getSize());
                    // Continue generating random moves until a valid move is found
                } while (playGround.setSymbol(row, col, currentPlayer));

                // Announce the computer's move to the player
                System.out.println("Computer played at (" + (row + 1) + ", " + (col + 1) + ")");
            }
            // Check if the current player has won the game
            if (playGround.checkWin(currentPlayer)) {
                playGround.printBoard(); // Display the final state of the board
                // Announce the winner (either the player or the computer)
                System.out.println("Game over! " + (currentPlayer == Symbol.X ? "Player" : "Computer") + " " + currentPlayer.getValue() + " wins!");
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






