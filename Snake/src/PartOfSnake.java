public class PartOfSnake implements MapObject {
    public final Type type = Type.SNAKE;
    public final Point coordinate;

    public PartOfSnake(Point coordinate){
        this.coordinate = coordinate;
    }

    public Type getType(){
        return type;
    }

    public void moveToThisObject(Snake snake){
        snake.killTheSnake();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartOfSnake that = (PartOfSnake) o;

        if (type != that.type) return false;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + coordinate.hashCode();
        return result;
    }
}
