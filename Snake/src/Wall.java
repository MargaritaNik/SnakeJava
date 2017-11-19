import Models.*;

import java.awt.Color;

public class Wall implements MapObject{
    public final Point position;

    public Wall(Point point){
        position = point;
    }

    public Color getColor(){ return Color.BLACK;}

    public void moveToThisObject(Snake snake, Field field){
        snake.killTheSnake();
    }

    public Model getModel(){
        return new WallModel();
    }
}
