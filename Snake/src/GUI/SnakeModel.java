package GUI;

import java.awt.*;

public class SnakeModel implements Model {
    public void drawCell(Graphics2D graphics2D, int x, int y){
        graphics2D.draw3DRect(x * 30, 570 - y * 30, 30, 30, true);
        graphics2D.draw3DRect(x * 30 + 3, 570 - y * 30 + 3, 24, 24, true);
        graphics2D.draw3DRect(x * 30 + 6, 570 - y * 30 + 6, 18, 18, true);
        graphics2D.draw3DRect(x * 30 + 9, 570 - y * 30 + 9, 12, 12, true);
        graphics2D.draw3DRect(x * 30 + 12, 570 - y * 30 + 12, 6, 6, true);
        graphics2D.draw3DRect(x * 30 + 14, 570 - y * 30 + 14, 2, 2, true);
    }
}
