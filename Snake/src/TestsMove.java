import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestsMove {
    private Field field;
    private Snake snake;
    private Direction direction;

    @Before
    public void initialization() {
        field = new Field();
        snake = new Snake();
    }

    @Test
    public void moveToWallTest() {
        Move.move(field, snake, Direction.DOWN);
        Assert.assertFalse(snake.getIsAlive());
    }

    @Test
    public void moveSnakeTest() throws Exception {
        Move.move(field, snake, Direction.RIGHT);
        assertEquals(2, snake.snake.getFirst().coordinate.getX());
        assertEquals(1, snake.snake.getFirst().coordinate.getY());
        assertEquals(5, snake.snake.getLast().coordinate.getX());
        assertEquals(1, snake.snake.getLast().coordinate.getY());

    }

    @Test
    public void moveToFruitTest() {
        field.stateCell.put(new Point(5, 1), new Fruit());
        Move.move(field, snake, Direction.RIGHT);
        Move.move(field, snake, Direction.RIGHT);
        assertEquals(5, snake.snake.size());

    }
}
