import java.util.ArrayList;
import java.util.List;

public class TraversalNode {

    public static int count = 0;
    
    private boolean isPlayerOne;
    private Direction directionLeadingToThisNode;
    private List<TraversalNode> childNodes;
    private TerminationNode terminationNode = null;
    
    public TraversalNode(boolean isPlayerOne, Location playerLocation, Location opponentLocation, Direction directionToThis, Board board) {
        
        count++;
        
        this.isPlayerOne = isPlayerOne;
        directionLeadingToThisNode = directionToThis;
                
        List<Direction> availableDirections = board.getAvailableDirectionsAt(playerLocation);
        
        //base case: if no available direction, then the other player has won the game
        if (availableDirections.isEmpty()) {
            terminationNode = new TerminationNode(isPlayerOne);
        } 
        
        //check what opponent can do for all players available moves 
        else {
            childNodes = new ArrayList<>();
            
            for (Direction direction : availableDirections) {
               
                Location newPlayerLocation = new Location(playerLocation.oneStep(direction));
                
                Board newBoard = new Board(board, newPlayerLocation, !isPlayerOne);
                TraversalNode node = new TraversalNode(!isPlayerOne, opponentLocation, newPlayerLocation, direction, newBoard);
                childNodes.add(node);
            }
        }
    }
    
    public boolean isPlayerOne() {
        return isPlayerOne;
    }
    
    public Direction getDirection() {
        return directionLeadingToThisNode;
    }
    
    public boolean terminatesGame() {
        if (terminationNode != null) {
            return true;
        }
        
        return false;
    }
    
    public boolean playerOneWin() {
        return terminationNode.playerOneWin();
    }
    
    public TraversalNode nodeInDirection(Direction direction) {
        for (TraversalNode node : childNodes) {
            if (node.getDirection().equals(direction)) {
                return node;
            }
        }
        
        throw new RuntimeException("Graph does not contain all possible moves");
    }    
    
    public NodeOutcome getOutcomeInBranch() {
       
        NodeOutcome outcome = new NodeOutcome();

        if (terminationNode != null) {
            outcome.playerOneWins(terminationNode.playerOneWin());
        } else {
            for (TraversalNode node : childNodes) {
                outcome.add(node.getOutcomeInBranch()); 
            }
        }
                
        return outcome;
    }
    
    List<TraversalNode> getChildNodes() {
        return childNodes;
    }
}
