import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main {
    static Direction direction;
    static Field field;
    static Snake snake;
    static JPanel panel;

    public static void main(String[] args) {
        initializate();
        while (true) {
            if (!snake.getIsAlive())
                break;
            snake.setCurrentDirection(direction);
            Move.move(field, snake);
        }
    }

    public static void initializate(){
        panel = new JPanel();
        panel.setFocusable(true);
        direction = Direction.RIGHT;
        field = new Field();
        snake = new Snake();
        panel.addKeyListener(new KeyControl());
    }

}