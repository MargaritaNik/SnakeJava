public class SnakePart implements MapObject {

    public final Point position;

    public SnakePart(Point position) {
        this.position = position;
    }

    public void moveToThisObject(Snake snake) {
        snake.killTheSnake();
    }

}