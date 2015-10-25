import java.util.ArrayList;
import java.util.List;

public class Board {
	/*
	 * initializes the board with spesifyed dimension
	 */
    
    //board represented by nxn matrix, where first axis is defined as horizontal (ie board(horizontal, vertical) or (row, column))
    //(0,0) is defined as upper left corner
    private static SquareState[][] board;
    
    private static BoardFrame UI;
    
    public static enum SquareState {
        Unoccupied, PlayerOne, PlayerTwo;  
    }
    
    public static void initBoard(int dimension, BoardFrame userInterface) {
	    board = new SquareState[dimension][dimension];
	    UI = userInterface;
	    //set entire board up to be Unoccupied
	    for (SquareState[] row : board) {
	        for (SquareState square : row) {
	            square = SquareState.Unoccupied;
	        }
	    }
	}
    
	/* direction is one of North, South, East and West. */
	public static List<Direction> getAvailableDirectionsAt(Location location){ 
	   
	    //assume all are available, and remove if not
	    List<Direction> directions = new ArrayList<Direction>();
	    
	    directions.add(Direction.North);
	    directions.add(Direction.East);
	    directions.add(Direction.South);
	    directions.add(Direction.West);

	    
	    //check if valid coordinate
        
	    int maxIndexRow = maxRowIndex();
	    int maxIndexColumn = maxColumnIndex();
	    
	    
	    int row = location.row();
	    int column = location.column();
	    
	    //check if invalid index north and south
	    if (column < 0) {
	        directions.remove(Direction.South);
	    } else if (column > maxIndexColumn) {
            directions.remove(Direction.North);
        }
	    
	    //check if invalid index east and west
	    if (row < 0) {
            directions.remove(Direction.West);
        } else if (row > maxIndexRow) {
            directions.remove(Direction.East);
        }
	    
	    
	    if (directions.contains(Direction.North)) {
	        if ( ! board[row - 1][column].equals(SquareState.Unoccupied) ) {
	            directions.remove(Direction.North);
	        }
	    }
	    
	    if (directions.contains(Direction.East)) {
            if ( ! board[row][column + 1].equals(SquareState.Unoccupied) ) {
                directions.remove(Direction.East);
            }
        }
	    
	    if (directions.contains(Direction.South)) {
            if ( ! board[row + 1][column].equals(SquareState.Unoccupied) ) {
                directions.remove(Direction.South);
            }
        }
	    
	    if (directions.contains(Direction.West)) {
            if ( ! board[row][column - 1].equals(SquareState.Unoccupied) ) {
                directions.remove(Direction.West);
            }
        }
	    
	    return directions;
	}
		
	/*
	 * precondition: must be a valid move
	 * current position of player is updated internally
	 */
	public static void playerPositionUpdated(Player player, Location location) {
	    
	    //update player position
	    if (player.isPlayerOne()) {
	        updateSquareInBoard(location, SquareState.PlayerOne);
	    } else {
            updateSquareInBoard(location, SquareState.PlayerTwo);
	    } 
	}
	
    private static void updateSquareInBoard(Location location, SquareState state) {
        
        board[location.row()][location.column()] = state;
        UI.updateUI(location, state);
    }
    	
	
	public static int maxRowIndex() {
	    return board.length - 1;
	}
	
	public static int maxColumnIndex() {
        return board[0].length - 1;
    }
	
    public static SquareState squareState(Location location) {
        return board[location.row()][location.column()];
    }
	
    public static SquareState squareState(int row, int column) {
        return board[row][column];
    }
    
    public static boolean isUnoccupied(Location location) {
        if (board[location.row()][location.column()].equals(SquareState.Unoccupied)) return true;
        return false;
    }
    
	public static String serialize(){ 
	    
	    //TODO: implement!
	    return null;     
	}
}

