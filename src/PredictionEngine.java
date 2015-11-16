import java.util.HashSet;
import java.util.Set;

public abstract class PredictionEngine {
    
    public Direction getNextMove(Player player, Board board) {
        
        return randomChoice(player);
    }
    
    private Direction randomChoice(Player player, Board board) {
        //makes a random chouce as t direction in which to go
        
        
        
    }
    
    private Direction intelligentChoice(Player player, Board board) {
        
    }
    
    
    
    private simulatedPlayerMove(Location player, Location oponent, Board board) {
        
        //base cases
        
        player.
        
        
    }
    
    private simulatedOpoentMove(Location player, Location oponent, Board board) {
       
        Set<Direction> availableDirections = getAvailableDirections(oponent, board);
        
        //base cases
        if (availableDirections.isEmpty()) {
            return 
        }
        
        for (Direction direction : availableDirections) {
            simulatePlayerMove(player, oponent.oneStep(direction), board);
        }
        
        
        
    }
    
    

    
}
