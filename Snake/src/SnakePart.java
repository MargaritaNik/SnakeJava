public class SnakePart implements MapObject {
    public final Point position;

    public SnakePart(Point position){
        this.position = position;
    }


    public void moveToThisObject(Snake snake){
        snake.killTheSnake();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnakePart snakePart = (SnakePart) o;

        return position.equals(snakePart.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
