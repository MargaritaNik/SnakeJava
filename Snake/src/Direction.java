public enum Direction {
    UP(new Point(0,1)),
    RIGHT(new Point(1,0)),
    LEFT(new Point(-1,0)),
    DOWN(new Point(0,-1));

    private final Point shift;

    Direction(Point point){
        shift = point;
    }

    public Point getShift(){
        return shift;
    }

    public boolean isOpposite(Direction direction){
        if(this.shift.add(direction.shift) == new Point(0,0) )
            return true;
        return false;
    }

}
