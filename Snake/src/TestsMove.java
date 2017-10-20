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

    @Test(expected = Exception.class)
    public void moveToWallTest() throws Exception {
        Move.move(field,snake, Direction.DOWN);
    }

    @Test(expected = Exception.class)
    public void moveToSnakeTest() throws Exception {
        Move.move(field,snake, Direction.LEFT);
        assertEquals(snake.snake.getFirst().getX(), 2);
        assertEquals(snake.snake.getFirst().getY(), 1);
        assertEquals(snake.snake.getLast().getX(), 5);
        assertEquals(snake.snake.getLast().getY(), 1);
    }

    @Test
    public  void moveToFruiteTest() throws Exception{
        field.stateCell.put(new Point(5,1), Type.FRUIT);
        Move.move(field,snake, Direction.RIGHT);
        Move.move(field,snake, Direction.RIGHT);
        assertEquals(5,snake.snake.size());

    }
}
