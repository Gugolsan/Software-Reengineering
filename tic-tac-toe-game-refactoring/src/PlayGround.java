//public class PlayGround {
//
//    private final char[][] board = new char[3][3];
//
//    public PlayGround() {
//        init();
//    }
//
//    public void setSymbol(int row, int col, Symbol symbol) {
//        board[row][col] = symbol.getValue();
//    }
//
//    public void init() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board[i][j] = Symbol.BLANK.getValue();
//            }
//        }
//    }
//    public void printBoard() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                // System.out.print(board[i][j] + Symbol.BLANK);
//            }
//        }
//    }
//}

/**
 * Represents the playing board for a Tic Tac Toe game.
 * This class is responsible for managing the game board, including initializing the board,
 * setting symbols, checking for wins, and determining if the board is full.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @class PlayGround
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public class PlayGround {
    private final Symbol[][] board;
    private final int size;

    /**
     * Constructs a new PlayGround with the specified size.
     * Initializes the board with blank symbols.
     *
     * @param size the size of the board (number of rows and columns)
     */
    public PlayGround(int size) {
        this.size = size;
        this.board = new Symbol[size][size];
        initializeBoard();
    }

    /**
     * Initializes the board with blank symbols.
     */
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Symbol.BLANK;
            }
        }
    }

    /**
     * Prints the current state of the board to the console.
     */
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j].getValue() + " ");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    /**
     * Attempts to set the given symbol at the specified row and column.
     *
     * @param row    the row to set the symbol at (0-based)
     * @param col    the column to set the symbol at (0-based)
     * @param symbol the symbol to set
     * @return true if the move is invalid or the cell is not blank, false otherwise
     */
    public boolean setSymbol(int row, int col, Symbol symbol) {
        if (row < 0 || col < 0 || row >= size || col >= size || board[row][col] != Symbol.BLANK) {
            return true;
        }
        board[row][col] = symbol;
        return false;
    }

    /**
     * Checks if the specified symbol has won the game.
     *
     * @param symbol the symbol to check for a win
     * @return true if the symbol has won, false otherwise
     */
    public boolean checkWin(Symbol symbol) {
        char sym = symbol.getValue();

        // Check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowMatch = true;
            boolean colMatch = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j].getValue() != sym) {
                    rowMatch = false;
                }
                if (board[j][i].getValue() != sym) {
                    colMatch = false;
                }
            }
            if (rowMatch || colMatch) {
                return true;
            }
        }

        // Check diagonals
        boolean diag1Match = true;
        boolean diag2Match = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i].getValue() != sym) {
                diag1Match = false;
            }
            if (board[i][size - 1 - i].getValue() != sym) {
                diag2Match = false;
            }
        }

        return (diag1Match || diag2Match);
    }

    /**
     * Determines if the board is full (no blank spaces left).
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Symbol.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gets the size of the board.
     *
     * @return the size of the board
     */
    public int getSize() {
        return size;
    }
}
