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
        assertEquals(new Point(1, 2), snake.getSnakeTail().position);
    }

    @Test
    public void addToHeadTest(){
        snake.addToHead(new Point(5, 1));
        assertEquals(new Point(5, 1), snake.getSnakeHead().position);
    }

    @Test
    public void cutTailTest() {
        Point deletedPoint = snake.getSnakeTail().position;
        snake.cutTail();
        Assert.assertFalse(snake.contains(new SnakePart(deletedPoint)));
    }
    


}

