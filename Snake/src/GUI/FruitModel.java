package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class FruitModel implements Model, ImageObserver {
    public void drawCell(Graphics2D graphics2D, int x, int y){
    }

    public boolean imageUpdate(Image img, int status, int x, int y, int height, int width){
        if((status & ALLBITS) != 1)
            return true;
        return false;
    }
}
