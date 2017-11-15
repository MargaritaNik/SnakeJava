import org.junit.After;
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
        snake = new Snake(new Point(1,1), 5, Direction.RIGHT);
    }

    @Test
    public void moveToOppositeTest(){
        Move.move(field, snake, Direction.LEFT);
        assertEquals(new Point(2, 1), snake.getSnakeTail().position);
        assertEquals(new Point(6, 1), snake.getSnakeHead().position);
    }

    @Test
    public void moveToFruitTest() {
        field.add(new Point(6, 1), new Fruit(50, new Point(6, 1)));
        Move.move(field, snake, Direction.RIGHT);
        Move.move(field, snake, Direction.RIGHT);
        assertEquals(6, snake.getSnakeSize());
        assertEquals(SnakePart.class, snake.objectSearch(new Point(6,1)).getClass());
        Assert.assertFalse(field.contains(new Point(6,1)));
    }

    @Test
    public void moveToWallTest() {
        field.add(snake.getSnakeHead().position.add(Direction.RIGHT.getShift()), new Wall(snake.getSnakeHead().position.add(Direction.RIGHT.getShift())));
        Move.move(field, snake, Direction.RIGHT);
        Assert.assertFalse(snake.getIsAlive());
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

    @Test
    public void moveToSelfTest(){
        Move.move(field, snake, Direction.UP);
        Move.move(field, snake, Direction.LEFT);
        Move.move(field, snake, Direction.DOWN);
        Assert.assertFalse(snake.getIsAlive());
    }
}
