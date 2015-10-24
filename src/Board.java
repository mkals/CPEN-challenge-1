import java.util.ArrayList;
import java.util.List;

public class Board {
	/*
	 * initializes the board with spesifyed dimension
	 */
    
    //board represented by nxn matrix, where first axis is defined as horizontal (ie board(horizontal, vertical) or (row, column))
    //(0,0) is defined as upper left corner
    private static SquareState[][] board;
    
    private static int edgeWidth = 1;

    public static enum SquareState {
        Unoccupied, PlayerOneCurrent, PlayerOnePast, PlayerTwoCurrent, PlayerTwoPast;  
    }
    
    private static String player1Name;
    private static String player2Name;
    
    public Board(int dimension) {
	    board = new SquareState[dimension + edgeWidth*2][dimension + edgeWidth*2];
	    	    
	    //set entire board up to be Unoccupied
	    for (SquareState[] row : board) {
	        for (SquareState square : row) {
	            square = SquareState.Unoccupied;
	        }
	    }
	}
    
	/* direction is one of North, South, East and West. */
	public List<Direction> getAvailableDirectionsAt(Location location){ 
	    List<Direction> availableDirections = new ArrayList<Direction>();
	    
	    //check north
	    if (board[location.x()][location.y() - 1].equals(SquareState.Free)) {
	        availableDirections.add(Direction.North);
	    } 
	    
	    //check east
        if (board[location.x() + 1][location.y()].equals(SquareState.Free)) {
            availableDirections.add(Direction.East);
        } 
       
        //check south
        if (board[location.x()][location.y() + 1].equals(SquareState.Free)) {
            availableDirections.add(Direction.South);
        } 
        
        //check west
        if (board[location.x() - 1][location.y()].equals(SquareState.Free)) {
            availableDirections.add(Direction.West);
        } 
        
	    return availableDirections;
	}
		
	public void playerPositionUpdated(String playerName, Location location) {
	    
	    //update player position
	    if (playerName.equals(player1Name)) {
	        board[location.x()][location.y()] = SquareState.Player1;
	    } else if (playerName.equals(player2Name)) {
	        board[location.x()][location.y()] = SquareState.Player2;
	    } 
	    
	    //add player and set their initial position
	    else if (player1Name.isEmpty()) {
	        player1Name = playerName;
	        board[location.x()][location.y()] = SquareState.Player1;
	    } else if (player2Name.isEmpty()) {
	        player2Name = playerName;
	        board[location.x()][location.y()] = SquareState.Player2;
	    } 
	    
	    //unrecognized player name, unrecoverable game state
	    else {
	        System.out.println("THRID PLAYER TRYED ACCESS, FATAL ERROR");
	        //TODO: throw unchecked exception
	    }
	}

	public int maxRowIndex() {
	    return board.length - 1;
	}
	
    public SquareState squareState(Location location) {
        return board[location.x()][location.y()];
    }
	
    public SquareState squareState(int row, int column) {
        return board[row][column];
    }
    
	public String serialize(){ 
	    
	    //TODO: implement!
	    return null;     
	}
}

