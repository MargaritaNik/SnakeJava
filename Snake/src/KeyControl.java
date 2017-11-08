import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyControl implements KeyListener{
    HashMap<Integer, Direction> actions;

    public void keyPressed(KeyEvent pushButton){
        Main.direction = actions.get(pushButton);
    }

    public void keyReleased(KeyEvent pushButton){};

    public void keyTyped(KeyEvent pushButton){};

    public KeyControl(){
        actions = new HashMap<>();
        actions.put(KeyEvent.VK_LEFT, Direction.LEFT);
        actions.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
        actions.put(KeyEvent.VK_UP, Direction.UP);
        actions.put(KeyEvent.VK_DOWN, Direction.DOWN);
    }
}
