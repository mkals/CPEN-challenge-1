
public class Location {
    
    private int xCoordinate;
    private int yCoordinate;
        
    public Location(int x, int y) {
        moveTo(x, y);
    }
    
    public Location(Location location) {
        moveTo(location);
    }

    public void moveTo(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }
    
    public void moveTo(Location location) {
        xCoordinate = location.xCoordinate;
        yCoordinate = location.yCoordinate;
    }
    
    
    //Access and set location variables separately
    public int x() {
        return xCoordinate;
    }
    
    public int y() {
        return yCoordinate;
    }
    
    public void x(int x) {
        xCoordinate = x;
    }
    
    public void y(int y) {
        yCoordinate = y;
    }
    
}
