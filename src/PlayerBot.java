
public class PlayerBot extends Player {

    public PlayerBot(boolean isPlayerOne, Location startingLocation, GameBoard board) {
    
        super(isPlayerOne, startingLocation, board);

    }
    
    Location makeMove(Location oponentLocation, GameBoard board) {
        
        if (board.getGraph() == null) {
            if (Math.abs( oponentLocation.row() - super.getLocation().row()) < 2 && Math.abs( oponentLocation.column() - super.getLocation().column()) < 2 ) {
                board.initGraph(this.getLocation(), oponentLocation);
            } else {
                
                if (super.isPlayerOne()) {
                    return super.getLocation().oneStep(Direction.South);
                } else {
                    return super.getLocation().oneStep(Direction.North);
                }
            }
        }
        
        return super.getLocation().oneStep(board.getGraph().directionWithGratestWinningFraction()); 
    }


    
}
