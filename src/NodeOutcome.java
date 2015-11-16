
public class NodeOutcome {
        
    
        private int playerOneWins = 0;
        private int playerTwoWins = 0;
        
        public int playerOneWins() { return playerOneWins; }
        public int playerTwoWins() { return playerTwoWins; }
        
        public void playerOneWins(int playerOneWins) { this.playerOneWins = playerOneWins; }
        public void playerTwoWins(int playerTwoWins) { this.playerTwoWins = playerTwoWins; }
        
        public void playerOneWins(boolean playerOneWins) { 
            if (playerOneWins) this.playerOneWins++;
            else this.playerTwoWins++; 
        }   
        
        public void add(NodeOutcome outcome) {
            this.playerOneWins += outcome.playerOneWins;
            this.playerTwoWins += outcome.playerTwoWins;
        }
   
}
