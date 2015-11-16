
/**
 * Starting with player one, each second layer represents all possible moves for a player.
 * Termination node represents which of the player that end victorious on that particular branch. 
 * 
 * Root node is updated to reflect current game state
 * 
 * @author mKals
 *
 */

public class TraversalGraph {

    private TraversalNode rootNode;
    
    public TraversalGraph(Location playerLocation, Location opponentLocation, GameBoard gameBoard) {
        
        rootNode = new TraversalNode(false, playerLocation, opponentLocation, Direction.North, new Board(gameBoard));      
        
        System.out.println("TraversalNodes: " + TraversalNode.count + " terminalNodes: " + TerminationNode.count);
    }
    
    public GameState moveMadeInDirection(Direction direction) {
        
        rootNode = rootNode.nodeInDirection(direction);
        
        NodeOutcome outcome = rootNode.getOutcomeInBranch();
        
        if (outcome.playerOneWins() == 0) {
            return GameState.PlayerTwoIsWinner;
        } else if (outcome.playerTwoWins() == 0) {
            return GameState.PlayerOneIsWinner;
        }
        
        return null;
    }
    
    public Direction directionWithMostWins() { //bug found
            
        int wins = 0;
        Direction directionOfWins = null;
        
        for (TraversalNode node : rootNode.getChildNodes()) {

            NodeOutcome nodeOutcome = node.getOutcomeInBranch();

            if (rootNode.isPlayerOne() && wins <= nodeOutcome.playerOneWins() ) {
                wins = nodeOutcome.playerOneWins();
                directionOfWins = node.getDirection();
            }
            if (!rootNode.isPlayerOne() && wins <= nodeOutcome.playerTwoWins()) {
                wins = nodeOutcome.playerTwoWins();
                directionOfWins = node.getDirection();
            }              
        }
        
        return directionOfWins;
    }
    
    public Direction directionWithGratestWinningFraction() {
        
        double winFraction = -1;
        Direction directionOfWins = null;
        
        for (TraversalNode node : rootNode.getChildNodes()) {

            NodeOutcome nodeOutcome = node.getOutcomeInBranch();

            if (node.isPlayerOne()) {
                
                if (nodeOutcome.playerTwoWins() != 0.0) {
                    double fraction = (double) nodeOutcome.playerOneWins() / nodeOutcome.playerTwoWins();
                    
                    if (winFraction < fraction) {
                        winFraction = fraction;
                        directionOfWins = node.getDirection();
                    }
                } else { // all wins in this direction
                    return node.getDirection();
                }
                
            } else {
                if (nodeOutcome.playerOneWins() != 0.0) {
                    double fraction = (double) nodeOutcome.playerTwoWins() / nodeOutcome.playerOneWins();
                    
                    if (winFraction < fraction) {
                        winFraction = fraction;
                        directionOfWins = node.getDirection();
                    }
                } else { // all wins in this direction
                    return node.getDirection();
                }
            }
        }
        
        if (directionOfWins == null) {
            System.out.println("Fatal error, no direction chosen");
        }
        
        return directionOfWins;
    }
    
    public Direction directionWithLongestTillLoose() {
        
        
        
        return null;
    }
    
    enum GameState {
        PlayerOneIsWinner, PlayerTwoIsWinner, GameContinues;
    }
}
