import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Direction direction = Direction.RIGHT;
    static Field field = new Field();
    static Snake snake = new Snake();
    static GameWindow gameWindow = new GameWindow(){

        public void paint(Graphics graphics){
            Graphics2D graphics2D = (Graphics2D)graphics.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color currentColor;
            for (int x = 0; x < 20; x++)
                for (int y = 0; y < 20; y++) {
                    currentColor = Move.search(field, snake, new Point(x, y)).getColor();
                    if (currentColor == Color.BLACK)
                        graphics2D.draw3DRect(x * 20, y * 20, 20, 20, true);
                    if (currentColor == Color.GREEN) {
                        graphics2D.draw3DRect(x * 20, y * 20, 20, 20, true);
                        graphics2D.draw3DRect(x * 20 + 3, y * 20 + 3, 14, 14, true);
                        graphics2D.draw3DRect(x * 20 + 6, y * 20 + 6, 8, 8, true);
                        graphics2D.draw3DRect(x * 20 + 9, y * 20 + 9, 2, 2, true);
                    }
                    if (currentColor == Color.RED)
                        graphics2D.drawOval(x*20, y*20, 20, 20);
                }
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
        field.add(new Point(11, 1), new Fruit(50, new Point(11, 1)));
        while (true) {
            if (!snake.getIsAlive())
                break;
            if (snake.getIsFull())
                field.addRandomFruit(snake);
            gameWindow.repaint();
            Move.move(field, snake, direction);
            TimeUnit.MILLISECONDS.sleep(2000);
        }
    }

}