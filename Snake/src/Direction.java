public enum Direction {
    UP(new Point(0, 1)),
    RIGHT(new Point(1, 0)),
    LEFT(new Point(-1, 0)),
    DOWN(new Point(0, -1));

    private final Point shift;

    Direction(Point point) {
        shift = point;
    }

    public boolean isOpposite(Direction direction){
       return this.shift.add(direction.getShift()).equals(new Point(0,0));
    }

    public Point getShift() {
        return shift;
    }

}
