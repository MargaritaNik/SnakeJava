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
        snake.setCurrentDirection(Direction.DOWN);
        Move.move(field, snake);
        Assert.assertFalse(snake.getIsAlive());
    }

    @Test
    public void moveToSnakeTest() throws Exception {
        snake.setCurrentDirection(Direction.LEFT);
        Move.move(field, snake);
        assertEquals(new Point(2, 1), snake.snake.getFirst().position);
        assertEquals(new Point(5, 1), snake.snake.getLast().position);

    }

    @Test
    public void moveToFruitTest() {
        field.stateCell.put(new Point(5, 1), new Fruit());
        snake.setCurrentDirection(Direction.RIGHT);
        Move.move(field, snake);
        Move.move(field, snake);
        assertEquals(5, snake.snake.size());

    }
}
