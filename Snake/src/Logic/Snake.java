package Logic;

import java.util.*;
import java.io.Serializable;

public class Snake implements Serializable{

    private LinkedList<SnakePart> snake = new LinkedList();
    private boolean isFull;
    public SnakePart snakeTail;
    private boolean isAlive;
    private Direction currentDirection;

    public void setCurrentDirection(Direction direction) {
        if (!direction.isOpposite(currentDirection))
            currentDirection = direction;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }


    public boolean getIsAlive(){
        return this.isAlive;
    }

    public void setAlive(boolean isAlive){
        if (isAlive){
            Main.gameOverSound.stop();
            Main.gameSound.play();
            this.isAlive = isAlive;
        }
        else{
            Main.gameSound.stop();
            Main.gameOverSound.play();
            this.isAlive = isAlive;
        }
    }

    public void setFull(boolean full) {
        this.isFull = full;
    }

    public boolean getIsFull(){
        return this.isFull;
    }

    public Snake() {
        for (int x = 1; x < 5; x++)
            snake.add(new SnakePart(new Point(x, 1)));
        isFull = false;
        isAlive = true;
        currentDirection = Direction.RIGHT;
    }

    public Snake(Point tail, int size, Direction direction){
        for (int i = 0; i < size; i++) {
            snake.add(new SnakePart(tail));
            tail = tail.add(direction.getShift());
        }
        isFull = false;
        isAlive = true;
        currentDirection = direction;
    }

    public void addToTail(Point point) {
        snake.addFirst(new SnakePart(point));
    }

    public void addToHead(Point point) {
        snake.addLast(new SnakePart(point));
    }

    public void cutTail() {
        if(snake.size() == 1)
            isAlive = false;
        snake.removeFirst();
    }

    public void move(Direction direction, int fieldSize) {
        Point head = new Point(snake.getLast().position.add(direction.getShift()).x % fieldSize,
                snake.getLast().position.add(direction.getShift()).y % fieldSize );
        if (head.x == -1)
            head = new Point(fieldSize - 1, head.y);
        if (head.y == -1)
            head = new Point(head.x, fieldSize - 1);
        addToHead(head);
        cutTail();
    }

    public MapObject objectSearch(Point point){
        return snake
                .stream()
                .filter(x -> x.position.equals(point))
                .map(x -> (MapObject)x)
                .findFirst()
                .orElse(new EmptyObject());
    }

    public int getSnakeSize(){
        return snake.size();
    }
    public SnakePart getSnakeHead(){
        return snake.getLast();
    }
    public SnakePart getSnakeTail(){
        return snake.getFirst();
    }
    public ArrayList<SnakePart> getSnake(){
        return new ArrayList<SnakePart>(snake);
    }

    public boolean contains(SnakePart snakePart){
        return snake.contains(snakePart);
    }
}
