import java.util.*;
public class Snake {

    public LinkedList<Point> snake = new LinkedList();

    private Direction currentDirection;

    public void setCurrentDirection(Direction direction){
        if(!direction.isOpposite(currentDirection))
            currentDirection = direction;
    }

    public Direction getCurrentDirection(){
        return currentDirection;
    }


    public Snake(){
        for (int x = 1; x < 5; x++) {
            snake.add(new Point(x, 1));
        }
    }

    public void addToTail(Point point){
        snake.addFirst(point);
    }

    public void addToHead(Point point){
        snake.addLast(point);
    }

    public void cutTail(){
        snake.removeFirst();
    }

    public void move(Direction direction){
        addToHead(snake.getLast().add(direction.getShift()));
        cutTail();
    }
}
