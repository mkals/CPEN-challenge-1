
/**
 * board represented by nxn matrix, where first axis is defined as horizontal (ie board(horizontal, vertical) or (row, column))
 * (0,0) is defined as upper left corner
 * 
 * The game-board class will interface with the BoardFrame class to provide the graphical representation to the user.
 * 
 * @author mKals
 * 
 */

public class GameBoard extends Board {
        
    private BoardFrame boardFrame;
    
    private TraversalGraph graph;
    
    public void initGraph(Location location, Location oponentLocation) {
        graph = new TraversalGraph(location, oponentLocation, this);
    }
    
    public TraversalGraph getGraph() {
        return graph;
    }
    
    public void updateInfoPanelInUI(boolean turnOfPlayer1) {
        boardFrame.updateInfoPanel(turnOfPlayer1);
    }
    
    public GameBoard(Game.Mode mode, int dimension, Game gameInstance) {
        
        super(dimension);
        
        boardFrame = new BoardFrame(dimension, dimension, mode, gameInstance);
        boardFrame.setVisible(true);
        
	}
    
    public void playerPositionUpdated(Player player, Location location) {
        
        //update player position
        if (player.isPlayerOne()) {
            updateSquareInBoard(location, SquareState.PlayerOne);
        } else {
            updateSquareInBoard(location, SquareState.PlayerTwo);
        } 
    }
    
    private void updateSquareInBoard(Location location, SquareState state) {
        
        super.board[location.row()][location.column()] = state;
        boardFrame.updateUI(location, state);
    }
    
	public static String serialize(){ 
	    
	    //TODO: implement!
	    return null;     
	}
}

