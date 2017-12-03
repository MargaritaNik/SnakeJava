package Logic;

import java.io.Serializable;

public class GameSave implements Serializable {
    Field field;
    Snake snake;
    Direction direction;

    public GameSave(){
        field = Main.field;
        snake = Main.snake;
        direction = Main.direction;
    }
}
