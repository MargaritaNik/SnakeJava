import java.util.*;

public class Snake {

    private LinkedList<SnakePart> snake = new LinkedList();
    private boolean isFull;
    public SnakePart snakeTail;
    private boolean isAlive;



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

    public Snake() {
        for (int x = 1; x < 5; x++)
            snake.add(new SnakePart(new Point(x, 1)));
        isFull = false;
        isAlive = true;
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

    public void move(Direction direction) {
        addToHead(snake.getLast().position.add(direction.getShift()));
        cutTail();
    }

    public MapObject objectSearch(Point point){
        for (SnakePart e: snake){
            if (e.position == point)
                return e;
        }
        return new EmptyObject();
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
