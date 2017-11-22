package Logic;

import GUI.*;

public class SnakePart implements MapObject {

    public final Point position;

    public SnakePart(Point position) {
        this.position = position;
    }

    public void moveToThisObject(Snake snake, Field field) {
        snake.killTheSnake();
    }

    public void accept(IVisitor visitor){
        visitor.paint(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnakePart snakePart = (SnakePart) o;

        return position != null ? position.equals(snakePart.position) : snakePart.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}