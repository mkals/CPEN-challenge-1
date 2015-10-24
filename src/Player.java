
public class Player {
	
    private static Location startingLocation = new Location(1,1); //update
    
    private String name;
    private PlayerType playerType;
    private PlayerNumber playerNumber;
    
    //must know the board, what is legal moves, where it is relative to other stuff
    
    Location location;    
	public enum PlayerType {
        Bot, Human;
	}
	
	public enum PlayerNumber {
	    One, Two;
	}
	
	private Player(){
	    location = new Location(startingLocation);
	}
		
	/*
	 * initializes player with name and type
	 */
	
	public Player(String name, PlayerType type){
	    this();

	    name = this.name;
	    playerType = type;
	   // TODO: set player number
	}

	/*
	 * returns current location of player
	 */
	public Location getLocation(){
	    return location;
	}

	public boolean isPlayerOne() {
	    if (playerNumber.equals(PlayerNumber.One)) return true;
	    return false;
	}
	
	/*
	 * Executes the players move disition by:
	 * - checking if location is available, using the availableLication method
	 * - moving player to new location
	 */
	public boolean moveTo(Direction direction){ 

	    switch (direction) {
	    case North:
	        break;
	    case East: 
	        break;
	    case South:
	        break;
	    case West: 
	        break;
	    }
	    
        return false;       
	}	
	
	/*
	 * Gets the current location of the opponent
	 * 
	 */
	public Location getOpponentLocation(){ 
	    
	    return null;
	}
	
	
	private boolean availableLocation(Location location) {
	    
	    //TODO: check it the location object wants to move to is available. 
	    return true; 
	}
}

