
public class Player {
	    
    private boolean IS_PLAYER1;
    
    private Location playerLocation; 
    

	public Player(boolean isPlayerOne, Location startingLocation, GameBoard board){
	    this.IS_PLAYER1 = isPlayerOne;
	    
	    moveTo(startingLocation, board);
	}

	/**
	 * returns current location of player
	 */
	public Location getLocation(){
	    return playerLocation;
	}

	public boolean isPlayerOne() {
	    return IS_PLAYER1;
	}
	
	/**
	 * Executes the players move desition by:
	 * - checking if location is available, using the availableLication method
	 * - moving player to new location
	 */
	public boolean moveTo(Location location, GameBoard board){ 

	    if (isValidMove(location, board)) {
	        playerLocation = new Location(location);
	        board.playerPositionUpdated(this, playerLocation);
	        return true;
	    }
	    
        return false;       
	}	
	
	public boolean moveIn(Direction direction, GameBoard board) {
	    return moveTo(this.playerLocation.oneStep(direction), board);
	}
	
	public boolean isValidMove(Location newLocation, GameBoard board) {
	   
	    if (board.isUnoccupied(newLocation)) {
	        
	        //for initialization when location is not set yet
	        if (playerLocation == null) return true;
	        
	        //otherwise, to see if it is one step away from current player position
	        for (Direction direction : Direction.values()) {
	            if (playerLocation.oneStep(direction).equals(newLocation)) return true; 
	        }
	    }   
	    
        return false;
	}
}