public class Fruit implements MapObject {
    public final Type type = Type.FRUIT;
    public final int points;

    public Fruit(int points){
        this.points = points;
    }

    public Fruit(){
        this.points = 50;
    }

    public void moveToThisObject(Snake snake){
        snake.setFull(true);
        snake.snakeTail = snake.snake.getFirst();
    }
}
