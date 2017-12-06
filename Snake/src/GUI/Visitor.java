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
        } catch (IOException e){
            throw new RuntimeException(e);
        }
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
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(img, position.x*30, 570 - position.y*30, 30, 30, this);
    }

    public boolean imageUpdate(Image img, int status, int x, int y, int height, int width){
        return(status & ALLBITS) != 1;
    }
}
