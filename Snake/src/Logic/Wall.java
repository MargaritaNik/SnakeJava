package Logic;

import GUI.*;
import java.io.Serializable;

import java.awt.Color;

public class Wall implements MapObject, Serializable{
    public final Point position;

    public Wall(Point point){
        position = point;
    }

    public Color getColor(){ return Color.BLACK;}

    public void moveToThisObject(Snake snake, Field field){
        snake.setAlive(false);
    }

    public void accept(IVisitor visitor){
        visitor.paint(this);
    }
}
