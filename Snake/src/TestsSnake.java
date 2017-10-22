import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;
import java.util.*;

public class TestsSnake {
    private Snake snake;

    @Before
    public void initialization() {
        snake = new Snake();
    }

    @Test
    public void addToTailTest() {
        snake.addToTail(new Point(1, 2));
        assertEquals(new Point(1, 2), snake.snake.getFirst().coordinate);
    }

    @Test
    public void addToHeadTest(){
        snake.addToHead(new Point(5, 1));
        assertEquals(new Point(5, 1), snake.snake.getLast().coordinate);
    }

    @Test
    public void cutTailTest() {
        Point deletedPoint = snake.snake.getFirst().coordinate;
        snake.cutTail();
        Assert.assertFalse(snake.snake.contains(new PartOfSnake(deletedPoint)));
    }
    
    @Test
    public void moveTest(){
        ArrayList<MapObject> beforeMoveSnake = new ArrayList<MapObject>(snake.snake);
        snake.move(Direction.UP);
        for (int i = snake.snake.size() - 2; i <= 0; i--)
            Assert.assertEquals(beforeMoveSnake.get(i), snake.snake.get(i + 1));
    }

}

