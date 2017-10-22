public class Wall implements MapObject{
    public final Type type = Type.WALL;

    public void moveToThisObject(Snake snake){
        snake.killTheSnake();
    }
}
