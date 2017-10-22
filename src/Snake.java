import java.util.*;

public class Snake {

    public LinkedList<SnakePart> snake = new LinkedList();
    private Direction currentDirection;
    private boolean isFull;
    public SnakePart snakeTail;
    private boolean isAlive;

    public void setCurrentDirection(Direction direction) {
        if (!direction.isOpposite(currentDirection))
            currentDirection = direction;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }

    public void setFull(boolean full) {
        this.isFull = full;
    }

    public boolean getIsFull(){
        return this.isFull;
    }

    public void killTheSnake(){
        this.isAlive = false;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Snake() {
        for (int x = 1; x < 5; x++)
            snake.add(new SnakePart(new Point(x, 1)));
        isFull = false;
        isAlive = true;
        currentDirection = Direction.RIGHT;
    }

    public void addToTail(Point point) {
        snake.addFirst(new SnakePart(point));
    }

    public void addToHead(Point point) {
        snake.addLast(new SnakePart(point));
    }

    public void cutTail() {
        snake.removeFirst();
    }

    public void move() {
        addToHead(snake.getLast().position.add(currentDirection.getShift()));
        cutTail();
    }

    public MapObject objectSearch(Point point){
        for (SnakePart e: snake){
            if (e.position == point)
                return e;
        }
        return null;
    }
}
