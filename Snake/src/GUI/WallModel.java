package GUI;

import java.awt.*;

//public class WallModel implements Model, ImageObserver{
public class WallModel implements Model{
//    public void drawCell(Graphics2D graphics2D, int x, int y){
//        graphics2D.draw3DRect(x * 30, 570 - y * 30, 30, 30, true);
//    }
public void drawCell(Graphics2D graphics2D, int x, int y){
    graphics2D.draw3DRect(x*30, 570 - y*30, 30, 30, true);
//    BufferedImage img = null;
//    try {
//        img = ImageIO.read(new File("Logic.Snake\\src\\images\\wall.jpg"));
//    } catch (IOException e){}
//    graphics2D.drawImage(img, x*30, 570 - y*30, 30, 30, this);
}

//    public boolean imageUpdate(Image img, int status, int x, int y, int height, int width){
//        if((status & ALLBITS) != 1)
//            return true;
//        return false;
//    }
}
