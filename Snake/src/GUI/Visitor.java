package GUI;

import Logic.*;
import Logic.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Visitor implements IVisitor, ImageObserver {

    private Graphics2D graphics2D;
    private Point position;

    public Visitor(Graphics2D graphics2D, Point position){
        this.graphics2D = graphics2D;
        this.position = position;
    }

    public void paint(Fruit fruit){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Snake\\src\\images\\apple.png"));
        } catch (IOException e){}
        graphics2D.drawImage(img, position.x*30, 570 - position.y*30, 30, 30, this);
    }

    public void paint(Wall wall){
        graphics2D.draw3DRect(position.x*30, 570 - position.y*30, 30, 30, true);
    }

    public void paint(EmptyObject empty){};

    public void paint(SnakePart snake){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Snake\\src\\images\\body.png"));
        } catch (IOException e){}
        graphics2D.drawImage(img, position.x*30, 570 - position.y*30, 30, 30, this);
//        graphics2D.draw3DRect(position.x * 30, 570 - position.y * 30, 30, 30, true);
//        graphics2D.draw3DRect(position.x * 30 + 3, 570 - position.y * 30 + 3, 24, 24, true);
//        graphics2D.draw3DRect(position.x * 30 + 6, 570 - position.y * 30 + 6, 18, 18, true);
//        graphics2D.draw3DRect(position.x * 30 + 9, 570 - position.y * 30 + 9, 12, 12, true);
//        graphics2D.draw3DRect(position.x * 30 + 12, 570 - position.y * 30 + 12, 6, 6, true);
//        graphics2D.draw3DRect(position.x * 30 + 14, 570 - position.y * 30 + 14, 2, 2, true);
    }

    public boolean imageUpdate(Image img, int status, int x, int y, int height, int width){
        if((status & ALLBITS) != 1)
            return true;
        return false;
    }
}
