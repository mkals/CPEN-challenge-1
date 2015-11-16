
public class Location {
    
    private int storedColumn;
    private int storedRow;
        
    public Location(int row, int column) {
        moveTo(row, column);
    }
    
    public Location(Location location) {
        moveTo(location);
    }

    public void moveTo(int row, int column) {
        storedRow = row;
        storedColumn = column;
    }
    
    public void moveTo(Location location) {
        storedColumn = location.storedColumn;
        storedRow = location.storedRow;
    }
    
    
    //Access and set location variables 
    public int column() {
        return storedColumn;
    }
    
    public int row() {
        return storedRow;
    }
    
    public void column(int column) {
        storedColumn = column;
    }
    
    public void row(int row) {
        storedRow = row;
    }
    
    
    public Location oneStep(Direction direction) {
        
       switch (direction) {
       
       case North: 
           return new Location(storedRow - 1, storedColumn);

       case East:
           return new Location(storedRow, storedColumn + 1);

       case South:
           return new Location(storedRow + 1, storedColumn);
           
       default:
           return new Location(storedRow, storedColumn - 1);
       }
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof Location) {
            Location location = (Location) obj;
            
            if (this.row() == location.row() && this.column() == location.column()) return true;
        }
        
        return false;
    }
}
