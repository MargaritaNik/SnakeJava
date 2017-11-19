package Models;

import java.awt.*;

public class WallModel implements Model {
    public void drawCell(Graphics2D graphics2D, int x, int y){
        graphics2D.draw3DRect(x * 20, 380 - y * 20, 20, 20, true);
    }
}
