import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    static Direction direction = Direction.RIGHT;
    static Field field = new Field();
    static Snake snake = new Snake();
    static GameWindow gameWindow = new GameWindow() {

        public void paint(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (int x = 0; x < 20; x++)
                for (int y = 0; y < 20; y++)
                    Move.search(field, snake, new Point(x, y)).getModel().drawCell(graphics2D, x, y);
            Point head = snake.getSnakeHead().position;
            graphics2D.setColor(new Color(134, 136,  138));
            graphics2D.draw3DRect(head.x * 20 + 1, 380 - head.y * 20 + 1, 18, 18, false);
            graphics2D.draw3DRect(head.x * 20 + 2, 380 - head.y * 20 + 2, 16, 16, false);
            graphics2D.draw3DRect(head.x * 20 + 7, 380 - head.y * 20 + 7, 6, 6, false);
            graphics2D.draw3DRect(head.x * 20 + 8, 380 - head.y * 20 + 8, 4, 4, false);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Frame(gameWindow);
                frame.setTitle("Snake");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        gameWindow.addKeyListener(new KeyControl());
        gameWindow.setFocusable(true);
        field.addRandomFruit(snake);
        while (snake.getIsAlive())
            makeTurn();
    }

    public static void makeTurn() throws InterruptedException {
        gameWindow.repaint();
        Move.move(field, snake, direction);
        TimeUnit.MILLISECONDS.sleep(500);
    }

}