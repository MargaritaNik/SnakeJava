package Logic;

import GUI.*;
import java.io.Serializable;

public class Fruit implements MapObject, Serializable {

    public final int points;
    public final Point position;

    public Fruit(int points, Point position){
        this.points = points;
        this.position = position;
    }

    public void moveToThisObject(Snake snake, Field field) {
        Main.eatSound.play(false);
        snake.setFull(true);
        snake.snakeTail = snake.getSnakeTail();
        field.deleteFruit(this);
        field.addRandomFruit(snake);
    }

    public void accept(IVisitor visitor){
        visitor.paint(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        if (points != fruit.points) return false;
        return position != null ? position.equals(fruit.position) : fruit.position == null;
    }

    @Override
    public int hashCode() {
        int result = points;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
