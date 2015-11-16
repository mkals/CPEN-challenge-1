
public class TerminationNode {
    
    private final boolean playerOneWin;
    
    public static int count = 0;
    
    public TerminationNode(boolean playerOneWin) {
        count++;
        this.playerOneWin = playerOneWin;
    }
    
    public boolean playerOneWin() {
        return playerOneWin;
    }
    
}
