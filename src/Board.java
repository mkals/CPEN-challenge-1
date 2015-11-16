import java.util.ArrayList;
import java.util.List;

/**
 * board represented by nxn matrix, where first axis is defined as horizontal
 * (ie board(horizontal, vertical) or (row, column)) (0,0) is defined as upper
 * left corner
 * 
 * 
 * @author mKals
 * 
 */

public class Board {

    protected SquareState[][] board;

    public enum SquareState {
        Unoccupied, PlayerOne, PlayerTwo;
    }

    public Board(int dimension) {
        
        board = new SquareState[dimension][dimension];

        // set entire board up to be Unoccupied
        for (int row = 0; row <= maxIndex(); row++) {
            for (int column = 0; column <= maxIndex(); column++) {
                board[row][column] = SquareState.Unoccupied;
            }
        }
    }

    public Board(Board board) {
               
        this.board = new SquareState[board.board.length][board.board.length];

        for (int row = 0; row <= maxIndex(); row++) {
            for (int column = 0; column <= maxIndex(); column++) {
                this.board[row][column] = board.board[row][column];
            }
        }
    }

    public Board(Board board, Location location, boolean isPlayerOne) {

        this(board);

        if (isPlayerOne) {
            updateSquareInBoard(location, SquareState.PlayerOne);
        } else {
            updateSquareInBoard(location, SquareState.PlayerTwo);
        }
    }

    /* direction is one of North, South, East and West. */
    public List<Direction> getAvailableDirectionsAt(Location location) {

        List<Direction> availableDirections = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            if (isUnoccupied(location.oneStep(direction))) {
                availableDirections.add(direction);
            }
        }

        return availableDirections;
    }

    /*
     * precondition: must be a valid move current position of player is updated
     * internally
     */

    private void updateSquareInBoard(Location location, SquareState state) {
        board[location.row()][location.column()] = state;
    }

    public int maxIndex() {
        return board.length - 1;
    }

    public SquareState squareState(Location location) {
        return board[location.row()][location.column()];
    }

    public SquareState squareState(int row, int column) {
        return board[row][column];
    }

    public boolean isUnoccupied(Location location) {
        if (isValidLocation(location)) {
            if (board[location.row()][location.column()].equals(SquareState.Unoccupied)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidLocation(Location location) {
        int row = location.row();
        int column = location.column();

        if (0 <= row && row < board.length) {
            if (0 <= column && column < board[0].length)
                return true;
        }

        return false;
    }
}
