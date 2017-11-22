package GUI;

import Logic.Direction;
import Logic.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter {
    public void keyPressed(KeyEvent keyEvent){
        int key = keyEvent.getKeyCode();
        if (key == KeyEvent.VK_RIGHT)
            Main.direction = Direction.RIGHT;
        if (key == KeyEvent.VK_DOWN)
            Main.direction = Direction.DOWN;
        if (key == KeyEvent.VK_LEFT)
            Main.direction = Direction.LEFT;
        if (key == KeyEvent.VK_UP)
            Main.direction = Direction.UP;
    }
}
