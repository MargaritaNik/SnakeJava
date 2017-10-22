import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;
import java.util.*;

public class TestsSnake{
    private Snake snake;

    @Before
    public void initialization() {
        snake = new Snake();
    }

    @Test
    public void addToTailTest() {
        snake.addToTail(new Point(1, 2));
        assertEquals(new Point(1, 2), snake.snake.getFirst().position);
    }

    @Test
    public void addToHeadTest(){
        snake.addToHead(new Point(5, 1));
        assertEquals(new Point(5, 1), snake.snake.getLast().position);
    }

    @Test
    public void cutTailTest() {
        Point deletedPoint = snake.snake.getFirst().position;
        snake.cutTail();
        Assert.assertFalse(snake.snake.contains(new SnakePart(deletedPoint)));
    }
    
    @Test
    public void moveTest(){
        ArrayList<MapObject> beforeMoveSnake = new ArrayList<MapObject>(snake.snake);
        snake.setCurrentDirection(Direction.UP);
        snake.move();
        for (int i = snake.snake.size() - 2; i <= 0; i--)
            Assert.assertEquals(beforeMoveSnake.get(i), snake.snake.get(i + 1));
    }

   /*@Test
    public void objectSearchTest() {
        Point needPoint = new Point(5,1);
        MapObject point = new MapObject() {
            @Override
            public void moveToThisObject(Snake snake) {
                snake.killTheSnake();
            }
        };

        SnakePart snakePart= new SnakePart(needPoint);
        snakePart.moveToThisObject(snake);

        assertEquals(snakePart , snake.objectSearch(needPoint) );
    }*/

}

