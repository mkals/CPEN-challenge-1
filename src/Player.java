
public class Player {
	
    private static Location startingLocation = new Location(1,1); //update
    
    private String name;
    private Type playerType;
    private Number playerNumber;
    
    //must know the board, what is legal moves, where it is relative to other stuff
    
    Type type() {
        return playerType;
    }
    
    Location playerLocation;    
	public enum Type {
        Bot, Human;
	}
	
	public enum Number {
	    One, Two;
	}
	
	private Player(){
	    playerLocation = new Location(startingLocation);
	}
		
	/*
	 * initializes player with name and type
	 */
	
	public Player(String name, Type type){
	    this();

	    name = this.name;
	    playerType = type;
	   // TODO: set player number
	}

	/*
	 * returns current location of player
	 */
	public Location getLocation(){
	    return playerLocation;
	}

	public boolean isPlayerOne() {
	    if (playerNumber.equals(Number.One)) return true;
	    return false;
	}
	
	/*
	 * Executes the players move disition by:
	 * - checking if location is available, using the availableLication method
	 * - moving player to new location
	 */
	public boolean moveTo(Player player, Location location){ 

	    if (isValidMove(location)) {
	        playerLocation = location;
	        Board.playerPositionUpdated(player, playerLocation);
	        return true;
	    }
	    
        return false;       
	}	
	
	boolean isValidMove(Location newLocation) {
	    
	    if (Board.isUnoccupied(newLocation)) {
	        if (playerLocation.oneStepNorth().equals(newLocation)) {
	            return true; 
	        } else if (playerLocation.oneStepEast().equals(newLocation)) {
	            return true; 
            } else if (playerLocation.oneStepSouth().equals(newLocation)) {
                return true; 
            } else if (playerLocation.oneStepWest().equals(newLocation)) {
                return true; 
            } 
	    }   
	    
        return false;
	}
	
	Location makeMove(Location oponentLocation) {
	    return null;
	}
	
	/*
	 * Gets the current location of the opponent
	 * 
	 */
	public Location getOpponentLocation(){ 
	    
	    return null;
	}
	
	

}

