/**
 * Enumerates the symbols used in the Tic Tac Toe game.
 * Each symbol represents a state of a cell on the game board: X, O, or BLANK.
 * The BLANK symbol represents an empty cell.
 *
 * @author Volodymyr Voroniuk
 * @project tic-tac-toe-game-refactoring
 * @enum Symbol
 * @version 1.0.0
 * @since 23.04.24 - 14.00
 */
public enum Symbol {
    X('X'),
    O('O'),
    BLANK('_');

    private final char value;

    /**
     * Constructs a Symbol with the specified character value.
     *
     * @param value the character value of the symbol
     */
    Symbol(char value) {
        this.value = value;
    }

    /**
     * Retrieves the character value of the symbol.
     *
     * @return the character value of the symbol
     */
    public char getValue() {
        return value;
    }
}

