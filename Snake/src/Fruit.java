import java.awt.Color;

public class Fruit implements MapObject {

    public final int points;
    public final Point position;

    public Fruit(int points, Point position){
        this.points = points;
        this.position = position;
    }

    public Color getColor(){ return Color.RED;}

    public void moveToThisObject(Snake snake, Field field){
        snake.setFull(true);
        snake.snakeTail = snake.getSnakeTail();
        field.remove(snake.getSnakeHead().position);
    }
}
