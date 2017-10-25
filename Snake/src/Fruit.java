public class Fruit implements MapObject {

    public final int points;

    public Fruit(int points){
        this.points = points;
    }

    public Fruit(){
        this.points = 50;
    }

    public void moveToThisObject(Snake snake, Field field){
        snake.setFull(true);
        snake.snakeTail = snake.getSnakeTail();
        field.remove(snake.getSnakeHead().position);
    }
}
