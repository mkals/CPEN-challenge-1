
public class Location {
    
    private int storedColumn;
    private int storedRow;
        
    public Location(int column, int row) {
        moveTo(column, row);
    }
    
    public Location(Location location) {
        moveTo(location);
    }

    public void moveTo(int column, int row) {
        storedColumn = column;
        storedRow = row;
    }
    
    public void moveTo(Location location) {
        storedColumn = location.storedColumn;
        storedRow = location.storedRow;
    }
    
    
    //Access and set location variables separatelrow
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
    
    public Location oneStepNorth() {
        return new Location(storedColumn, storedRow - 1);
    }

    public Location oneStepEast() {
        return new Location(storedColumn + 1, storedRow);
    }
    
    public Location oneStepSouth() {
        return new Location(storedColumn, storedRow + 1);
    }
    
    public Location oneStepWest() {
        return new Location(storedColumn - 1, storedRow);
    }
    
    
}
