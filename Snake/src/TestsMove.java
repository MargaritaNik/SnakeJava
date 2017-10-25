import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

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
    public void moveToSnakeTest(){
        Move.move(field, snake, Direction.LEFT);
        assertEquals(new Point(2, 1), snake.getSnakeTail().position);
        assertEquals(new Point(5, 1), snake.getSnakeHead().position);

    }

    @Test
    public void moveToFruitTest() {
        field.add(new Point(5, 1), new Fruit());
        Move.move(field, snake, Direction.RIGHT);
        Move.move(field, snake, Direction.RIGHT);
        assertEquals(5, snake.getSnakeSize());


    }
    @Test
    public void moveTest(){
        ArrayList<SnakePart> beforeMoveSnake = snake.getSnake();
        snake.move(Direction.UP);
        beforeMoveSnake.remove(0);
        beforeMoveSnake.add(beforeMoveSnake.size(),
                new SnakePart(beforeMoveSnake.get(beforeMoveSnake.size()-1).position.add(Direction.UP.getShift())));
        ArrayList<SnakePart> afterMoveSnake = snake.getSnake();
        for (int i = 0; i<snake.getSnakeSize(); i++)
            Assert.assertEquals(beforeMoveSnake.get(i), afterMoveSnake.get(i));
    }
}
