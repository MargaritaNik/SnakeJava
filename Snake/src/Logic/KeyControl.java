package Logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

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
        if (key == KeyEvent.VK_S)
            try {
                SaveLoader.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (key == KeyEvent.VK_L)
            try {
                SaveLoader.load();
                Main.gameOverSound.stop();
                if (!Main.gameSound.isPlaying())
                    Main.gameSound.play();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        if (key == KeyEvent.VK_R){
            Main.gameOverSound.stop();
            Main.gameSound.play();
            Main.snake = new Snake();
            Main.direction = Direction.RIGHT;
            Main.field = new Field();
            Main.field.addRandomFruit(Main.snake);
        }
    }
}
