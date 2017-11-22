package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class FruitModel implements Model, ImageObserver {
    public void drawCell(Graphics2D graphics2D, int x, int y){
        //graphics2D.drawOval(x*20, 380 - y*20, 20, 20);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Logic.Snake\\src\\images\\apple.png"));
        } catch (IOException e){}
        graphics2D.drawImage(img, x*30, 570 - y*30, 30, 30, this);
    }

    public boolean imageUpdate(Image img, int status, int x, int y, int height, int width){
        if((status & ALLBITS) != 1)
            return true;
        return false;
    }
}
