import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class TestsSnake{
    private Field field;
    private Snake snake;

    @Before
    public void init()
    {
        field = new Field();
        snake = new Snake();
    }
    @Test
    public void addToTailTest(){
        snake.addToTail(new Point(1,2));
        assertEquals(new Point(1,2), snake.snake.getFirst());
    }

    @Test
    public void addToHeadTest(){
        snake.addToHead(new Point(5,1));
        assertEquals(new Point(5,1), snake.snake.getLast());
    }

    @Test
    public void cutToTailTest(){
        Point removePoint = snake.snake.getFirst();
        snake.cutTail();
        assertFalse(snake.snake.contains(removePoint));
    }
    @Test
    public void testMove(){
        ArrayList<Point> snakeBeforeMove = new ArrayList<Point>(snake.snake);
        snake.move(Direction.RIGHT);
        for(int i = 0; i < snake.snake.size()-1; i++){
            assertEquals(snake.snake.get(i), snakeBeforeMove.get(i+1));
        }
        assertEquals(snake.snake.getLast(), snakeBeforeMove.get(snakeBeforeMove.size()-1).add(Direction.RIGHT.getShift()));

    }

    }

