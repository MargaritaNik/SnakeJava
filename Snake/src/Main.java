import java.awt.*;
import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    static Direction direction = Direction.RIGHT;
    static Field field = new Field();
    static Snake snake = new Snake();
    static GUI gui = new GUI(){
        @Override
        public void paint(Graphics graphics){
            Graphics2D graphics2D = (Graphics2D)graphics.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color currentColor;
            for (int x = 0; x < 20; x++)
                for (int y = 0; y < 20; y++) {
                    currentColor = Move.search(field, snake, new Point(x, y)).getColor();
                    if (currentColor != null)
                        graphics2D.drawRect(x * 20, y * 20, 20, 20);
                }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        gui.initialization();
        gui.setVisible(true);
        while (true) {
            if (!snake.getIsAlive())
                break;
            gui.repaint();
            Move.move(field, snake, direction);
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

}